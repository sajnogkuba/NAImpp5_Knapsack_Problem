import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
    }
}
