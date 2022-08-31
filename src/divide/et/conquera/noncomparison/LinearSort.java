package divide.et.conquera.noncomparison;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinearSort {

    public static void main(String[] args) {
        try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberQuantity = Integer.parseInt(bufferReader.readLine());
            String numberLine = bufferReader.readLine();
            String[] stringNumbers = numberLine.split(" ");
            int[] numbers = new int[stringNumbers.length];
            for (int i = 0; i < stringNumbers.length; i++) {
                numbers[i] = Integer.parseInt(stringNumbers[i]);
            }
            int[] sortedNumbers = linearSort(numbers);
            String[] strings = new String[stringNumbers.length];
            for (int i = 0; i < stringNumbers.length; i++) {
                strings[i] = String.valueOf(sortedNumbers[i]);
            }
            System.out.println(String.join(" ", strings));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] linearSort(int[] numbers) {
        int high = 10;
        int[] numberFrequencies = new int[high];
        int[] additionalArray = new int[numbers.length];
        for (int currentNumber : numbers) {
            // j is a counter fo the initial array
            numberFrequencies[currentNumber - 1] = numberFrequencies[currentNumber - 1] + 1;
        }
        int k = 0;
        while (k < numberFrequencies.length - 1) {
            // actual number is k + 1
            int j = 0;
            while (j < additionalArray.length) {
                int numberCount = numberFrequencies[k];
                while (numberCount > 0) {
                    numberCount--;
                    additionalArray[j] = k + 1;
                    j++;
                }
                k++;
            }
        }
        return additionalArray;
    }
}