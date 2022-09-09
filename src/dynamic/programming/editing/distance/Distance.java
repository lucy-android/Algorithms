package dynamic.programming.editing.distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Distance {
    public static void main(String[] args) {
        try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in))) {
            String firstLine = bufferReader.readLine();
            String secondLine = bufferReader.readLine();
            char[] firstWordSymbols = firstLine.toCharArray();
            char[] secondWordSymbols = secondLine.toCharArray();
            System.out.println(calculateEditingDistance(firstWordSymbols, secondWordSymbols));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculateEditingDistance(char[] firstWordSymbols, char[] secondWordSymbols) {
        int firstLength = firstWordSymbols.length;
        int secondLength = secondWordSymbols.length;

        int[][] twoDimensionalArray = new int[firstLength + 1][secondLength + 1];
        for (int i = 0; i <= firstLength; i++) {
            for (int j = 0; j <= secondLength; j++) {
                twoDimensionalArray[i][j] = -1;
            }
        }

        // TODO initialize the first column and the first line

        for (int i = 0; i <= firstLength; i++) {
            if (i == 0) {
                twoDimensionalArray[i][0] = 0;
            } else {
                twoDimensionalArray[i][0] = i;
            }
        }


        for (int i = 0; i <= secondLength; i++) {
            if (i == 0) {
                twoDimensionalArray[0][i] = 0;
            } else {
                twoDimensionalArray[0][i] = i;
            }
        }

        twoDimensionalArray[0][0] = 0;
        for (int i = 1; i <= firstLength; i++) {
            for (int j = 1; j <= secondLength; j++) {
                int diff = findDiff(firstWordSymbols[i - 1], secondWordSymbols[j - 1]);
                twoDimensionalArray[i][j] = findMinimumOfThree(
                        twoDimensionalArray[i - 1][j] + 1,
                        twoDimensionalArray[i][j - 1] + 1,
                        twoDimensionalArray[i - 1][j - 1] + diff);

            }
        }

        return twoDimensionalArray[firstLength][secondLength];
    }

    private static int findMinimumOfThree(int first, int second, int third) {
        if (first <= second && first <= third) {
            return first;
        } else if (second <= first && second <= third) {
            return second;
        } else {
            return third;
        }
    }

    private static int findDiff(char firstWordSymbol, char secondWordSymbol) {
        if (firstWordSymbol == secondWordSymbol) {
            return 0;
        }
        return 1;
    }


    private static void printOutTheResultingArray(int[][] twoDimensionalArray) {
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[0].length; j++) {
                System.out.printf("%5d ", twoDimensionalArray[i][j]);
            }
            System.out.println();
        }
    }
}