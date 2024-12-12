package src;
import java.io.*;
import java.util.*;
public class Task1 {
    public static void compareFiles(String filePath1, String filePath2) throws IOException {
        try (BufferedReader br1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader br2 = new BufferedReader(new FileReader(filePath2))) {
            String line1, line2;
            int lineNumber = 1;
            while ((line1 = br1.readLine()) != null & (line2 = br2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    System.out.printf("Mismatch at line %d:%nFile1: %s%nFile2: %s%n", lineNumber, line1, line2);
                }
                lineNumber++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter path to first file: ");
            String filePath1 = scanner.nextLine().trim();
            System.out.print("Enter path to second file: ");
            String filePath2 = scanner.nextLine().trim();
            compareFiles(filePath1, filePath2);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}