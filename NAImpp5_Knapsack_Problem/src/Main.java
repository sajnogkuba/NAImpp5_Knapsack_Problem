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

        int[] itemsValues = new int[numberOfItems];
        dataString = dataFileScanner.nextLine();
        dataArr = dataString.split(",");
        for (int i = 0; i < dataArr.length; i++) {
            itemsValues[i] = Integer.parseInt(dataArr[i]);
        }

        int[] itemsWeights = new int[numberOfItems];
        dataString = dataFileScanner.nextLine();
        dataArr = dataString.split(",");
        for (int i = 0; i < dataArr.length; i++) {
            itemsWeights[i] = Integer.parseInt(dataArr[i]);
        }

        double numberOfCombinations = Math.pow(2, numberOfItems);
        int[] theBestCombination = new int[numberOfItems];
        int valueOfTheBestCombination = -1;

        for (int i = 0; i < numberOfCombinations; i++) {
            int[] binaryNumber = new int[numberOfItems];
            String binaryString = Integer.toBinaryString(i);
            int startIndex = numberOfItems - binaryString.length();
            for (int j = 0; j < binaryString.length(); j++){
                binaryNumber[startIndex + j] = Character.getNumericValue(binaryString.charAt(j));
            }
            int optionValue = 0;
            int optionWeight = 0;
            for (int k = 0; k < binaryNumber.length; k++) {
                if (binaryNumber[k] == 1){
                    optionWeight += itemsWeights[k];
                    optionValue += itemsValues[k];
                }
                if (optionWeight <= backpackCapacity && optionValue > valueOfTheBestCombination){
                    valueOfTheBestCombination = optionValue;
                    theBestCombination = binaryNumber;
                }
            }
            if (i % 1000 == 0){
                System.out.println("Iteration number: " + i
                        + " The best combination: " + Arrays.toString(theBestCombination)
                        + " Value of this combination: " + valueOfTheBestCombination);
            }
        }
        System.out.println("\nFINISH!");
        System.out.println("The best combination: " + Arrays.toString(theBestCombination)
                + " Value of this combination: " + valueOfTheBestCombination);
    }
}
