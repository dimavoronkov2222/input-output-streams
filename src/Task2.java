package src;
import java.io.*;
import java.util.Scanner;
public class Task2 {
    public static void findLongestLine(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String longestLine = "";
            int maxLength = 0;
            while ((line = br.readLine()) != null) {
                if (line.length() > maxLength) {
                    maxLength = line.length();
                    longestLine = line;
                }
            }
            System.out.printf("Longest line length: %d\nLongest line: %s\n", maxLength, longestLine);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter file path: ");
            String filePath = scanner.nextLine();
            findLongestLine(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
