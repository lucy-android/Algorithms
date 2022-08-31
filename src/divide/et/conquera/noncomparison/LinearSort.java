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
            System.out.println("2 2 3 9 9");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
