package divide.et.conquera.quicksort;

import java.util.Scanner;

class QSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");
        int lineSegmentNumber = Integer.parseInt(numbers[0]);
        int[] lineSegmentStartPoints = new int[lineSegmentNumber];
        int[] lineSegmentEndPoints = new int[lineSegmentNumber];
        while (counter < lineSegmentNumber) {
            String newLine = scanner.nextLine();
            if (!newLine.equals("")) {
                String[] lineSegment = newLine.split(" ");
                int firstNumber = Integer.parseInt(lineSegment[0]);
                int secondNumber = Integer.parseInt(lineSegment[1]);
                lineSegmentStartPoints[counter] = firstNumber;
                lineSegmentEndPoints[counter] = secondNumber;
                counter++;
            }

        }
        if (counter == lineSegmentNumber) {
            String newLine = scanner.nextLine();
            if (!newLine.equals("")) {
                String[] pointStringArray = newLine.split(" ");
                int[] intPointArray = new int[pointStringArray.length];
                int[] resultArray = new int[pointStringArray.length];
                for (int i = 0; i < pointStringArray.length; i++) {
                    intPointArray[i] = Integer.parseInt(pointStringArray[i]);
                }

                int length = lineSegmentStartPoints.length - 1;
                quickSort(lineSegmentStartPoints, 0, length);
                quickSort(lineSegmentEndPoints, 0, length);
                for (int k = 0; k < pointStringArray.length; k++) {
                    int n = binaryNotGreaterElementsSearch(intPointArray[k], lineSegmentStartPoints, 0, length);
                    int m = binarySmallerElementsSearch(lineSegmentEndPoints, intPointArray[k], 0, length);
                    resultArray[k] = n - m;
                }
                String[] stringResultArray = new String[resultArray.length];
                for (int x = 0; x < resultArray.length; x++) {
                    stringResultArray[x] = String.valueOf(resultArray[x]);
                }
                System.out.println(String.join(" ", stringResultArray));
            }
        }


        scanner.close();
    }

    public static void quickSort(int[] initialArray, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int pi = partitionArray(initialArray, startIndex, endIndex);
            quickSort(initialArray, startIndex, pi - 1);
            quickSort(initialArray, pi + 1, endIndex);
        }
    }


    private static int binaryNotGreaterElementsSearch(int searchedNumber, int[] sortedArray, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        if (searchedNumber >= sortedArray[endIndex]) {
            return endIndex;
        }
        if (searchedNumber < sortedArray[startIndex]) {
            return -1;
        }
        if (startIndex + 1 == endIndex) {
            if (searchedNumber >= sortedArray[endIndex]) {
                return endIndex;
            }
            return startIndex;
        }
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        if (sortedArray[middleIndex] == searchedNumber) {
            return middleIndex;
        } else if (sortedArray[middleIndex] < searchedNumber) {
            return binaryNotGreaterElementsSearch(searchedNumber, sortedArray, middleIndex, endIndex);
        } else {
            return binaryNotGreaterElementsSearch(searchedNumber, sortedArray, startIndex, middleIndex - 1);
        }
    }

    public static int binarySmallerElementsSearch(int[] sortedArray, int searchedNumber, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        if (searchedNumber > sortedArray[endIndex]) {
            return endIndex;
        }
        if (searchedNumber < sortedArray[startIndex]) {
            return -1;
        }
        if (startIndex + 1 == endIndex) {
            if (searchedNumber > sortedArray[endIndex]) {
                return endIndex;
            }
            return startIndex;
        }
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        if (sortedArray[middleIndex] <= searchedNumber) {
            return binaryNotGreaterElementsSearch(searchedNumber, sortedArray, middleIndex, endIndex);
        } else {
            return binaryNotGreaterElementsSearch(searchedNumber, sortedArray, startIndex, middleIndex);
        }
    }


    private static int partitionArray(int[] arrayToBePartitioned, int startIndex, int endIndex) {
        int pivot = arrayToBePartitioned[endIndex];

        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++) {
            if (arrayToBePartitioned[j] <= pivot) {
                i++;
                int temp = arrayToBePartitioned[i];
                arrayToBePartitioned[i] = arrayToBePartitioned[j];
                arrayToBePartitioned[j] = temp;
            }
        }

        int temp = arrayToBePartitioned[i + 1];
        arrayToBePartitioned[i + 1] = arrayToBePartitioned[endIndex];
        arrayToBePartitioned[endIndex] = temp;

        return i + 1;
    }
}