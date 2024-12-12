package src;
import java.io.*;
import java.util.*;
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path to save the data:");
        String filePath = scanner.nextLine();
        System.out.println("Enter integers separated by spaces:");
        String[] input = scanner.nextLine().split("\\s+");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        StringBuilder originalArray = new StringBuilder();
        StringBuilder evenNumbers = new StringBuilder();
        StringBuilder oddNumbers = new StringBuilder();
        StringBuilder reversedArray = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            originalArray.append(array[i]).append(" ");
            if (array[i] % 2 == 0) {
                evenNumbers.append(array[i]).append(" ");
            } else {
                oddNumbers.append(array[i]).append(" ");
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            reversedArray.append(array[i]).append(" ");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(originalArray.toString().trim() + "\n");
            writer.write(evenNumbers.toString().trim() + "\n");
            writer.write(oddNumbers.toString().trim() + "\n");
            writer.write(reversedArray.toString().trim() + "\n");
            System.out.println("Data successfully written to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
