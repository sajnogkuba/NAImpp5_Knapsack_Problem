import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input path to file with data: ");
        String dataPath = scanner.nextLine();
        File dataFile = new File(dataPath);
        while (!dataFile.exists()){
            System.out.println("File: '" + dataPath + "' does not exist, please try again.");
            System.out.print("Please input path to file with data: ");
            dataPath = scanner.nextLine();
            dataFile = new File(dataPath);
        }
        Scanner dataFileScanner = new Scanner(dataFile);
        String dataString = dataFileScanner.nextLine();
        String[] dataArr = dataString.split(" ");
        int backpackCapacity = Integer.parseInt(dataArr[0]);
        int numberOfItems = Integer.parseInt(dataArr[1]);

        int[] values = new int[numberOfItems];
        dataString = dataFileScanner.nextLine();
        dataArr = dataString.split(",");
        for (int i = 0; i < dataArr.length; i++) {
            values[i] = Integer.parseInt(dataArr[i]);
        }

        System.out.println(Arrays.toString(values));

    }
}
