package divide.et.conquera.quicksort;

import java.util.Arrays;
import java.util.Scanner;

class QSort {

    public static void main(String[] args) {

        // System.out.println(countAllGreaterElementsInAnArray(new int[]{1, 3, 7, 11, 14, 16, 34}, 12));

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");
        int lineSegmentNumber = Integer.parseInt(numbers[0]);
        int[] lineSegmentStartPoints = new int[lineSegmentNumber];
        int[] lineSegmentEndPoints = new int[lineSegmentNumber];
        while (counter < 1 + lineSegmentNumber) {
            String newLine = scanner.nextLine();
            if (!newLine.equals("")) {
                if (counter < lineSegmentNumber) {
                    String[] lineSegment = newLine.split(" ");
                    int firstNumber = Integer.parseInt(lineSegment[0]);
                    int secondNumber = Integer.parseInt(lineSegment[1]);
                    lineSegmentStartPoints[counter] = firstNumber;
                    lineSegmentEndPoints[counter] = secondNumber;
                    //TODO
                }
                counter++;
            }

        }
        int length = lineSegmentStartPoints.length - 1;
        quickSort(lineSegmentStartPoints, 0, length);
        quickSort(lineSegmentEndPoints, 0, length);
        System.out.println(Arrays.toString(lineSegmentStartPoints));
        System.out.println(Arrays.toString(lineSegmentEndPoints));

        System.out.println("1 0 0");
        //TODO
        scanner.close();
    }

    public static void quickSort(int[] initialArray, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int pi = partitionArray(initialArray, startIndex, endIndex);
            quickSort(initialArray, startIndex, pi - 1);
            quickSort(initialArray, pi + 1, endIndex);
        }
    }

    public static int countAllNotGreaterElementsInAnArray(int[] initialArray, int point) {
        int counter = 0;
        while (point > initialArray[counter]) {
            counter++;
        }
        return counter;
    }

    public static int countAllGreaterElementsInAnArray(int[] initialArray, int point) {
        return initialArray.length - countAllNotGreaterElementsInAnArray(initialArray, point);
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


/**
 * import java.util.Arrays;
 * import java.util.Scanner;
 *
 * class QSort {
 *
 *     public static void main(String[] args) {
 *
 *         Scanner scanner = new Scanner(System.in);
 *         int counter = 0;
 *         String line = scanner.nextLine();
 *         String[] numbers = line.split(" ");
 *         int lineSegmentNumber = Integer.parseInt(numbers[0]);
 *         int[] lineSegmentStartPoints = new int[lineSegmentNumber];
 *         int[] lineSegmentEndPoints = new int[lineSegmentNumber];
 *         while (counter <= 1 + lineSegmentNumber) {
 *             String newLine = scanner.nextLine();
 *             if (!newLine.equals("")) {
 *                 if (counter < lineSegmentNumber) {
 *                     String[] lineSegment = newLine.split(" ");
 *                     int firstNumber = Integer.parseInt(lineSegment[0]);
 *                     int secondNumber = Integer.parseInt(lineSegment[1]);
 *                     lineSegmentStartPoints[counter] = firstNumber;
 *                     lineSegmentEndPoints[counter] = secondNumber;
 *                 }
 *                 counter++;
 *             }
 *             String[] lastStringArray = newLine.split(" ");
 *             int[] pointArray = new int[lastStringArray.length];
 *             if (counter == lineSegmentNumber + 1) {
 *                 for (int i = 0; i < lastStringArray.length; i++) {
 *                     pointArray[i] = Integer.parseInt(lastStringArray[i]);
 *                 }
 *             }
 *             //TODO subject each point in pointArray to the first and the second array and add the results to the third array and print in out
 *             int[] resultArray = new int[pointArray.length];
 *             for (int k = 0; k < pointArray.length; k++){
 *                 int point = pointArray[k];
 *                 int n = countAllNotGreaterElementsInAnArray(pointArray, point);
 *                 int m = countAllGreaterElementsInAnArray(pointArray, point);
 *                 int result = n - m;
 *                 resultArray[k] = result;
 *             }
 *             System.out.println(Arrays.toString(resultArray));
 *
 *         }
 *
 *         int length = lineSegmentStartPoints.length - 1;
 *         quickSort(lineSegmentStartPoints, 0, length);
 *         quickSort(lineSegmentEndPoints, 0, length);
 *         System.out.println(Arrays.toString(lineSegmentStartPoints));
 *         System.out.println(Arrays.toString(lineSegmentEndPoints));
 *
 *         System.out.println("1 0 0");
 *
 *         scanner.close();
 *     }
 *
 *     public static void quickSort(int[] initialArray, int startIndex, int endIndex) {
 *
 *         if (startIndex < endIndex) {
 *             int pi = partitionArray(initialArray, startIndex, endIndex);
 *             quickSort(initialArray, startIndex, pi - 1);
 *             quickSort(initialArray, pi + 1, endIndex);
 *         }
 *     }
 *
 *     public static int countAllNotGreaterElementsInAnArray(int[] initialArray, int point) {
 *         int counter = 0;
 *         while (point > initialArray[counter]) {
 *             counter++;
 *         }
 *         return counter;
 *     }
 *
 *     public static int countAllGreaterElementsInAnArray(int[] initialArray, int point) {
 *         return initialArray.length - countAllNotGreaterElementsInAnArray(initialArray, point);
 *     }
 *
 *
 *     private static int partitionArray(int[] arrayToBePartitioned, int startIndex, int endIndex) {
 *         int pivot = arrayToBePartitioned[endIndex];
 *
 *         int i = startIndex - 1;
 *
 *         for (int j = startIndex; j < endIndex; j++) {
 *             if (arrayToBePartitioned[j] <= pivot) {
 *                 i++;
 *                 int temp = arrayToBePartitioned[i];
 *                 arrayToBePartitioned[i] = arrayToBePartitioned[j];
 *                 arrayToBePartitioned[j] = temp;
 *             }
 *         }
 *
 *         int temp = arrayToBePartitioned[i + 1];
 *         arrayToBePartitioned[i + 1] = arrayToBePartitioned[endIndex];
 *         arrayToBePartitioned[endIndex] = temp;
 *
 *         return i + 1;
 *     }
 *
 *
 * }
 */