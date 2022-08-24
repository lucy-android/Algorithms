package divide.et.conquera.quicksort;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;

class QSort {

    public static void main(String[] args) throws Exception {

/*        int[] intArray = new int[]{7, 2, 1, 8, 6, 3, 5, 3422, 685, 100, 1, 11, 0, 0, 0};

        // System.out.println(Arrays.toString(partitionArray(intArray, 0, 14)));

        quickSort(intArray, 0, 14);

        System.out.print(Arrays.toString(intArray));*/

        HashMap<Integer, LineSegmentEndComparable> hashMap = new HashMap<>();

        hashMap.put(0, new LineSegmentEndComparable("1 78"));
        hashMap.put(1, new LineSegmentEndComparable("4 6"));
        hashMap.put(2, new LineSegmentEndComparable("4 10"));
        hashMap.put(3, new LineSegmentEndComparable("4 26"));
        hashMap.put(4, new LineSegmentEndComparable("4 23"));

/*        LineSegmentEndComparable temp = hashMap.get(1);
        hashMap.put(1, hashMap.get(0));
        hashMap.put(0, temp);

        System.out.println(hashMap);*/

        quickSort(hashMap, 0, 4);
        System.out.println(hashMap);

/*        quickSort(hashMap, 0, 3);

        System.out.print(hashMap);*/



        /*int pivotIndex = selectPivotIndex(intArray);
        System.out.println(selectPivotIndex(intArray));
        int pivot = intArray[pivotIndex];
        int i = 0;
        int j = 0;
        while (j < intArray.length) {
            if (intArray[j] < pivot) {
                i++;
                int temp = intArray[i - 1];
                intArray[i - 1] = intArray[j];
                intArray[j] = temp;
            }
            j++;
        }
        System.out.println("i = " + i);

        int elementToBeDisplaced = intArray[i];
        intArray[i] = intArray[pivotIndex];
        intArray[pivotIndex] = elementToBeDisplaced;

        System.out.print("[");
        for (int number : intArray) {
            System.out.print(number + ", ");
        }
        System.out.print("]");*/

//        Scanner scanner = new Scanner(System.in);
//        int counter = 0;
//        String line = scanner.nextLine();
//        String[] numbers = line.split(" ");
//        while (counter < Integer.parseInt(numbers[1])) {
//            String newLine = scanner.nextLine();
//            if (!newLine.equals("")) {
//                counter++;
//            }
//
//        }
//
//        System.out.println("1 0 0");
//        scanner.close();
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

        //swap arrayToBePartitioned[i+1] and arrayToBePartitioned[endIndex]

        int temp = arrayToBePartitioned[i + 1];
        arrayToBePartitioned[i + 1] = arrayToBePartitioned[endIndex];
        arrayToBePartitioned[endIndex] = temp;

        return i + 1;
    }


    public static void quickSort(HashMap<Integer, LineSegmentEndComparable> initialArray, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int pi = partitionArray(initialArray, startIndex, endIndex);
            quickSort(initialArray, startIndex, pi - 1);
            quickSort(initialArray, pi + 1, endIndex);
        }
    }


    private static int partitionArray(HashMap<Integer, LineSegmentEndComparable> arrayToBePartitioned, int startIndex, int endIndex) {
        LineSegmentEndComparable pivot = arrayToBePartitioned.get(endIndex);

        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++) {
            LineSegmentEndComparable end = arrayToBePartitioned.get(j);
            if (end.compareTo(pivot) <= 0) {
                i++;
                LineSegmentEndComparable temp = arrayToBePartitioned.get(i);
                arrayToBePartitioned.put(i, arrayToBePartitioned.get(j));
                arrayToBePartitioned.put(j, temp);
            }
        }

        //swap arrayToBePartitioned[i+1] and arrayToBePartitioned[endIndex]

        LineSegmentEndComparable temp = arrayToBePartitioned.get(i + 1);
        arrayToBePartitioned.put(i + 1, arrayToBePartitioned.get(endIndex));
        arrayToBePartitioned.put(endIndex, temp);

        return i + 1;
    }

    /* private static <T extends Comparable<T>> int partitionArray(HashMap<Integer, T> arrayToBePartitioned, int startIndex, int endIndex) {
        T pivot = arrayToBePartitioned.get(0);

        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++) {
            if (arrayToBePartitioned.get(j).compareTo(pivot) <= 0) {
                i++;
                T temp = arrayToBePartitioned.get(1);
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

    public static <T extends Comparable<T>> void quickSort(HashMap<Integer, T> arrayToBePartitioned, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int pi = partitionArray(arrayToBePartitioned, startIndex, endIndex);
            quickSort(arrayToBePartitioned, startIndex, pi - 1);
            quickSort(arrayToBePartitioned, pi + 1, endIndex);
        }
    } */


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
}
