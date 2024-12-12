package src;
import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Task3 {
    public static void main(String[] args) {
        String filename = "D:\\1.txt";
        List<int[]> arrays = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strValues = line.split("\\s+");
                int[] array = new int[strValues.length];
                for (int i = 0; i < strValues.length; i++) {
                    array[i] = Integer.parseInt(strValues[i]);
                }
                arrays.add(array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        int globalSum = 0;
        for (int[] array : arrays) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int num : array) {
                if (num > max) max = num;
                if (num < min) min = num;
                sum += num;
            }
            System.out.println("Массив: " + Arrays.toString(array));
            System.out.println("Максимум: " + max);
            System.out.println("Минимум: " + min);
            System.out.println("Сумма: " + sum);
            System.out.println();
            if (max > globalMax) globalMax = max;
            if (min < globalMin) globalMin = min;
            globalSum += sum;
        }
        System.out.println("Глобальный максимум: " + globalMax);
        System.out.println("Глобальный минимум: " + globalMin);
        System.out.println("Общая сумма: " + globalSum);
    }
}