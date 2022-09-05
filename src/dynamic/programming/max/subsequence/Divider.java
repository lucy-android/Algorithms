package dynamic.programming.max.subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Divider {

    public static void main(String[] args) {
        try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberQuantity = Integer.parseInt(bufferReader.readLine());
            String[] numberStrings = bufferReader.readLine().split(" ");
            int[] numbers = new int[numberQuantity];
            int[] subSequenceLengths = new int[numberQuantity];
            for (int i = 0; i < numberQuantity; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]);
                subSequenceLengths[i] = -1;
            }
            int[] requiredArray = fillSubSequenceLengthArray(numbers, subSequenceLengths);
            int max = findMax(requiredArray);
            System.out.println(max);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findMax(int[] requiredArray) {
        int max = -1;
        for (int i = 0; i < requiredArray.length; i++) {
            if (requiredArray[i]> max) {
                max = requiredArray[i];
            }
        }
        return max;
    }

    private static int[] fillSubSequenceLengthArray(int[] numbers, int[] subSequenceLengths) {
        int counter = 0;
        while (counter < numbers.length) {
            if (counter == 0) {
                subSequenceLengths[counter] = 1;
            } else if (counter == 1) {
                if (numbers[counter] % numbers[0] == 0) {
                    subSequenceLengths[counter] = 2;
                } else {
                    subSequenceLengths[counter] = 1;
                }
            } else {
                int max = 0;
                for (int i = 0; i < counter; i++) {
                    if (subSequenceLengths[i] > max && numbers[counter] % numbers[i] == 0) {
                        max = subSequenceLengths[i];
                    }
                }
                subSequenceLengths[counter] = max + 1;
            }
            counter++;
        }
        return subSequenceLengths;
    }
}
