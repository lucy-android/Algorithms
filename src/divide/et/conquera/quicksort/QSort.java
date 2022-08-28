package divide.et.conquera.quicksort;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Scanner;

/** class QSort {

    public static void main(String[] args) {

        HashMap<Integer, LineSegmentStartComparable> hashMap = new HashMap<>();

        hashMap.put(0, new LineSegmentStartComparable("70 78"));
        hashMap.put(1, new LineSegmentStartComparable("5 6"));
        hashMap.put(2, new LineSegmentStartComparable("9 10"));
        hashMap.put(3, new LineSegmentStartComparable("-400 26"));
        hashMap.put(4, new LineSegmentStartComparable("21 23"));


        quickSort(hashMap, 0, 4);
        System.out.println(hashMap);

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");
        HashMap<Integer, LineSegmentStartComparable> lineSegmentHashMap = new HashMap<>();
        while (counter < 1 + Integer.parseInt(numbers[0])) {
            String newLine = scanner.nextLine();
            LineSegmentStartComparable lineSegment = new LineSegmentStartComparable(newLine);
            if (!newLine.equals("")) {
                if(counter < Integer.parseInt(numbers[0])){
                    lineSegmentHashMap.put(counter, lineSegment);
                }
                counter++;
            }

        }

        System.out.println("1 0 0");
        System.out.println(lineSegmentHashMap);
        scanner.close();
    }


    public static <T extends Comparable<T>> void quickSort(HashMap<Integer, T> initialArray, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int pi = partitionArray(initialArray, startIndex, endIndex);
            quickSort(initialArray, startIndex, pi - 1);
            quickSort(initialArray, pi + 1, endIndex);
        }
    }


    private static <T extends Comparable<T>> int partitionArray(HashMap<Integer, T> arrayToBePartitioned, int startIndex, int endIndex) {
        T pivot = arrayToBePartitioned.get(endIndex);

        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++) {
            T end = arrayToBePartitioned.get(j);
            if (end.compareTo(pivot) <= 0) {
                i++;
                T temp = arrayToBePartitioned.get(i);
                arrayToBePartitioned.put(i, arrayToBePartitioned.get(j));
                arrayToBePartitioned.put(j, temp);
            }
        }

        //swap arrayToBePartitioned[i+1] and arrayToBePartitioned[endIndex]

        T temp = arrayToBePartitioned.get(i + 1);
        arrayToBePartitioned.put(i + 1, arrayToBePartitioned.get(endIndex));
        arrayToBePartitioned.put(endIndex, temp);

        return i + 1;
    }


}

class LineSegmentBase {

    final int number1;
    final int number2;

    public LineSegmentBase(String twoNumbers) {
        String[] numberArray = twoNumbers.split(" ");
        this.number1 = Integer.parseInt(numberArray[0]);
        this.number2 = Integer.parseInt(numberArray[1]);
    }

}

class LineSegmentStartComparable extends LineSegmentBase implements Comparable<LineSegmentStartComparable> {

    public LineSegmentStartComparable(String twoNumbers) {
        super(twoNumbers);
    }

    @Override
    public int compareTo(@NotNull LineSegmentStartComparable o) {
        if (this.number1 > o.number1) {
            return 1;
        } else if (this.number1 < o.number1) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return number1 + " " + number2;
    }
}

class LineSegmentEndComparable extends LineSegmentBase implements Comparable<LineSegmentEndComparable> {

    public LineSegmentEndComparable(String twoNumbers) {
        super(twoNumbers);
    }

    @Override
    public int compareTo(@NotNull LineSegmentEndComparable o) {
        if (this.number2 > o.number2) {
            return 1;
        } else if (this.number2 < o.number2) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return number1 + " " + number2;
    }
} */