package dynamic.programming.knapsack.noreps.bu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in))) {
            String firstLine = bufferReader.readLine();
            String secondLine = bufferReader.readLine();
            String[] firstStringArray = firstLine.split(" ");
            int firstNumber = Integer.parseInt(firstStringArray[0]);
            String[] secondStringArray = secondLine.split(" ");
            int[] inputArray = new int[secondStringArray.length];
            for (int i = 0; i < secondStringArray.length; i++) {
                inputArray[i] = Integer.parseInt(secondStringArray[i]);
            }

            System.out.println(knapsackWithoutRepsBU(firstNumber, inputArray));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static int knapsackWithoutRepsBU(int weight, int[] goldChunkWeights) {
        int[][] result = new int[goldChunkWeights.length + 1][weight + 1];

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                result[i][j] = result[i - 1][j];
                if (goldChunkWeights[i - 1] <= j) {
                    result[i][j] = Math.max(result[i][j], result[i - 1][j - goldChunkWeights[i - 1]] + goldChunkWeights[i - 1]);
                }
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }
}