package src;
import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Task3 {
    public static void main(String[] args) {
        String filename = "D:\\1.txt";
        List<long[]> arrays = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strValues = line.split("\\s+");
                long[] array = new long[strValues.length];
                for (int i = 0; i < strValues.length; i++) {
                    array[i] = Long.parseLong(strValues[i]);
                }
                arrays.add(array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long globalMax = Long.MIN_VALUE;
        long globalMin = Long.MAX_VALUE;
        long globalSum = 0;
        for (long[] array : arrays) {
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            long sum = 0;
            for (long num : array) {
                if (num > max) max = num;
                if (num < min) min = num;
                sum += num;
            }
            System.out.println("Array: " + Arrays.toString(array));
            System.out.println("Maximum: " + max);
            System.out.println("Minimum: " + min);
            System.out.println("Sum: " + sum);
            System.out.println();
            if (max > globalMax) globalMax = max;
            if (min < globalMin) globalMin = min;
            globalSum += sum;
        }
        System.out.println("Global maximum: " + globalMax);
        System.out.println("Global minimum: " + globalMin);
        System.out.println("Total sum: " + globalSum);
    }
}