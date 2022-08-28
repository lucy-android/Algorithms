package divide.et.conquera.quicksort;

import java.util.Arrays;
import java.util.Scanner;

class QSort {

    public static void main(String[] args) {

/*        int[] intArray = new int[]{7, 2, 1, 8, 6, 3, 5, 3422, 685, 100, 1, 11, 0, 0, 0};

        quickSort(intArray, 0, 14);

        System.out.print(Arrays.toString(intArray));*/

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");
        int lineSegmentNumber = Integer.parseInt(numbers[0]);
        int[] lineSegmentStartPoints = new int[lineSegmentNumber];
        int[] lineSegmentEndPoints = new int[lineSegmentNumber];
        while (counter < 1 + Integer.parseInt(numbers[0])) {
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
 * class QSort {
 * <p>
 * public static void main(String[] args) {
 * <p>
 * HashMap<Integer, LineSegmentStartComparable> hashMap = new HashMap<>();
 * <p>
 * hashMap.put(0, new LineSegmentStartComparable("70 78"));
 * hashMap.put(1, new LineSegmentStartComparable("5 6"));
 * hashMap.put(2, new LineSegmentStartComparable("9 10"));
 * hashMap.put(3, new LineSegmentStartComparable("-400 26"));
 * hashMap.put(4, new LineSegmentStartComparable("21 23"));
 * <p>
 * <p>
 * quickSort(hashMap, 0, 4);
 * System.out.println(hashMap);
 * <p>
 * Scanner scanner = new Scanner(System.in);
 * int counter = 0;
 * String line = scanner.nextLine();
 * String[] numbers = line.split(" ");
 * HashMap<Integer, LineSegmentStartComparable> lineSegmentHashMap = new HashMap<>();
 * while (counter < 1 + Integer.parseInt(numbers[0])) {
 * String newLine = scanner.nextLine();
 * LineSegmentStartComparable lineSegment = new LineSegmentStartComparable(newLine);
 * if (!newLine.equals("")) {
 * if(counter < Integer.parseInt(numbers[0])){
 * lineSegmentHashMap.put(counter, lineSegment);
 * }
 * counter++;
 * }
 * <p>
 * }
 * <p>
 * System.out.println("1 0 0");
 * System.out.println(lineSegmentHashMap);
 * scanner.close();
 * }
 * <p>
 * <p>
 * public static <T extends Comparable<T>> void quickSort(HashMap<Integer, T> initialArray, int startIndex, int endIndex) {
 * <p>
 * if (startIndex < endIndex) {
 * int pi = partitionArray(initialArray, startIndex, endIndex);
 * quickSort(initialArray, startIndex, pi - 1);
 * quickSort(initialArray, pi + 1, endIndex);
 * }
 * }
 * <p>
 * <p>
 * private static <T extends Comparable<T>> int partitionArray(HashMap<Integer, T> arrayToBePartitioned, int startIndex, int endIndex) {
 * T pivot = arrayToBePartitioned.get(endIndex);
 * <p>
 * int i = startIndex - 1;
 * <p>
 * for (int j = startIndex; j < endIndex; j++) {
 * T end = arrayToBePartitioned.get(j);
 * if (end.compareTo(pivot) <= 0) {
 * i++;
 * T temp = arrayToBePartitioned.get(i);
 * arrayToBePartitioned.put(i, arrayToBePartitioned.get(j));
 * arrayToBePartitioned.put(j, temp);
 * }
 * }
 * <p>
 * //swap arrayToBePartitioned[i+1] and arrayToBePartitioned[endIndex]
 * <p>
 * T temp = arrayToBePartitioned.get(i + 1);
 * arrayToBePartitioned.put(i + 1, arrayToBePartitioned.get(endIndex));
 * arrayToBePartitioned.put(endIndex, temp);
 * <p>
 * return i + 1;
 * }
 * <p>
 * <p>
 * }
 * <p>
 * class LineSegmentBase {
 * <p>
 * final int number1;
 * final int number2;
 * <p>
 * public LineSegmentBase(String twoNumbers) {
 * String[] numberArray = twoNumbers.split(" ");
 * this.number1 = Integer.parseInt(numberArray[0]);
 * this.number2 = Integer.parseInt(numberArray[1]);
 * }
 * <p>
 * }
 * <p>
 * class LineSegmentStartComparable extends LineSegmentBase implements Comparable<LineSegmentStartComparable> {
 * <p>
 * public LineSegmentStartComparable(String twoNumbers) {
 * super(twoNumbers);
 * }
 *
 * @Override public int compareTo(@NotNull LineSegmentStartComparable o) {
 * if (this.number1 > o.number1) {
 * return 1;
 * } else if (this.number1 < o.number1) {
 * return -1;
 * } else {
 * return 0;
 * }
 * }
 * @Override public String toString() {
 * return number1 + " " + number2;
 * }
 * }
 * <p>
 * class LineSegmentEndComparable extends LineSegmentBase implements Comparable<LineSegmentEndComparable> {
 * <p>
 * public LineSegmentEndComparable(String twoNumbers) {
 * super(twoNumbers);
 * }
 * @Override public int compareTo(@NotNull LineSegmentEndComparable o) {
 * if (this.number2 > o.number2) {
 * return 1;
 * } else if (this.number2 < o.number2) {
 * return -1;
 * } else {
 * return 0;
 * }
 * }
 * @Override public String toString() {
 * return number1 + " " + number2;
 * }
 * }
 */