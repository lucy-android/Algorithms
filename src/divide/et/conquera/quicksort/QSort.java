package divide.et.conquera.quicksort;

import java.util.Scanner;

class QSort {

    public static void main(String[] args) {

        System.out.println(binaryNotGreaterElementsSearch(788, new int[]{-2, -1, 4, 6, 13, 16, 17, 18, 423, 500, 600, 585865}, 0, 11));

        /*Scanner scanner = new Scanner(System.in);
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
                    int n = countAllNotGreaterElementsInAnArray(lineSegmentStartPoints, intPointArray[k]);
                    int m = countAllSmallerElementsInAnArray(lineSegmentEndPoints, intPointArray[k]);
                    resultArray[k] = n - m;
                }
                String[] stringResultArray = new String[resultArray.length];
                for (int x = 0; x < resultArray.length; x++) {
                    stringResultArray[x] = String.valueOf(resultArray[x]);
                }
                System.out.println(String.join(" ", stringResultArray));
            }
        }

        scanner.close();*/
    }

    public static void quickSort(int[] initialArray, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int pivot = selectPivot(initialArray, startIndex, endIndex);
            int pi = partitionArray(pivot, initialArray, startIndex, endIndex);
            quickSort(initialArray, startIndex, pi - 1);
            quickSort(initialArray, pi + 1, endIndex);
        }

    }

    public static int countAllNotGreaterElementsInAnArray(int[] initialArray, int point) {
        int counter = 0;

        /* for (int number : initialArray) {
            if (point > number) {
                counter++;
            } else {
                break;
            }

        } */
        return counter;
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

    public static int countAllSmallerElementsInAnArray(int[] initialArray, int point) {
        int counter = 0;

        for (int number : initialArray) {
            if (point >= number) {
                counter++;
            } else {
                break;
            }

        }
        return counter;
    }


    private static int selectPivot(int[] initialArray, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > initialArray.length || endIndex < startIndex) {
            return -1;
        }
        if (endIndex == startIndex) {
            return initialArray[endIndex];
        } else if (initialArray.length == 1) {
            return initialArray[0];
        }

        int sumOfElements = 0;
        for (int j = startIndex; j <= endIndex; j++) {
            sumOfElements += initialArray[j];
        }

        int position = startIndex;
        int average = sumOfElements / (endIndex - startIndex + 1);
        int closestToAverage = -1;

        for (int i = startIndex; i <= endIndex; i++) {
            if (Math.abs(average - closestToAverage) >= Math.abs(average - initialArray[i])) {
                closestToAverage = initialArray[i];
                position = i;
            }
        }

        return initialArray[position];
    }


    private static int partitionArray(int pivot, int[] arrayToBePartitioned, int startIndex, int endIndex) {

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