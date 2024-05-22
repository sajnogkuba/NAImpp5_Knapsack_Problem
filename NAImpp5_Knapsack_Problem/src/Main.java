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
        String backpackData = dataFileScanner.nextLine();
        String[] backpackDataArr = backpackData.split(" ");
        int backpackCapacity = Integer.parseInt(backpackDataArr[0]);
        int numberOfItems = Integer.parseInt(backpackDataArr[1]);
    }
}
