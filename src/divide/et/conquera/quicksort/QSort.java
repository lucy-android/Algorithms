package divide.et.conquera.quicksort;

import java.util.Arrays;

class QSort {

    public static void main(String[] args) throws Exception {

        int[] intArray = new int[]{7, 2, 1, 8, 6, 3, 5, 3422, 685, 100, 1, 11, 0, 0, 0};

        // System.out.println(Arrays.toString(partitionArray(intArray, 0, 14)));

        quickSort(intArray, 0, 14);

        System.out.print(Arrays.toString(intArray));



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


}

class LineSegment {

    final int number1;
    final int number2;

    public LineSegment(String twoNumbers) {
        String[] numberArray = twoNumbers.split(" ");
        this.number1 = Integer.parseInt(numberArray[0]);
        this.number2 = Integer.parseInt(numberArray[1]);
    }

}
/**
package divide.et.conquera.quicksort;

        import org.jetbrains.annotations.NotNull;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.List;


/**
 class QSort {

 public static void main(String[] args) {

 // int[] intArray = new int[]{7, 2, 1, 8, 6, 3, 5, 3422, 685, 100, 1, 11, 0, 0, 0};

 ArrayList<LineSegmentEndComparable> arrayList = new ArrayList<>();
 for (int i = 0; i < 4; i++) {
 arrayList.add (new LineSegmentEndComparable("0 0"));
 }
 arrayList.set(0, new LineSegmentEndComparable("2 5"));
 arrayList.set(1, new LineSegmentEndComparable("1 7"));
 arrayList.set(2, new LineSegmentEndComparable("1 111"));
 arrayList.set(3, new LineSegmentEndComparable("0 3"));
 quickSort(arrayList, 0, 3);
 System.out.println(Collections.singletonList(arrayList));

 // System.out.println(Arrays.toString(partitionArray(intArray, 0, 14)));

 // quickSort(intArray, 0, 14);

 // System.out.print(Arrays.toString(intArray));



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


/**
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


 public static <T extends Comparable<T>> void quickSort(ArrayList<T> initialArray, int startIndex, int endIndex) {

 if (startIndex < endIndex) {
 int pi = partitionArray(initialArray, startIndex, endIndex);
 quickSort(initialArray, startIndex, pi - 1);
 quickSort(initialArray, pi + 1, endIndex);
 }
 }

 private static <T extends Comparable<T>> int partitionArray(ArrayList<T> arrayToBePartitioned, int startIndex, int endIndex) {
 T pivot = arrayToBePartitioned.get(endIndex);

 int i = startIndex - 1;

 for (int j = startIndex; j < endIndex; j++) {
 if (arrayToBePartitioned.get(endIndex).compareTo(pivot) <= 0) {
 i++;
 T temp = arrayToBePartitioned.get(i);
 arrayToBePartitioned.set(i, arrayToBePartitioned.get(j));
 arrayToBePartitioned.set(j, temp);
 }
 }

 //swap arrayToBePartitioned[i+1] and arrayToBePartitioned[endIndex]

 T temp = arrayToBePartitioned.get(i + 1);
 arrayToBePartitioned.set(i + 1, arrayToBePartitioned.get(endIndex));
 arrayToBePartitioned.set(endIndex, temp);

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
 return "number1: " + number1 + " number2: " + number2;
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


 /**
 class QSort {

 public static void main(String[] args) {

 // int[] intArray = new int[]{7, 2, 1, 8, 6, 3, 5, 3422, 685, 100, 1, 11, 0, 0, 0};

 ArrayList<LineSegmentEndComparable> arrayList = new ArrayList<>();
 for (int i = 0; i < 4; i++) {
 arrayList.add (new LineSegmentEndComparable("0 0"));
 }
 arrayList.set(0, new LineSegmentEndComparable("2 5"));
 arrayList.set(1, new LineSegmentEndComparable("1 7"));
 arrayList.set(2, new LineSegmentEndComparable("1 111"));
 arrayList.set(3, new LineSegmentEndComparable("0 3"));
 quickSort(arrayList, 0, 3);
 System.out.println(Collections.singletonList(arrayList));

 // System.out.println(Arrays.toString(partitionArray(intArray, 0, 14)));

 // quickSort(intArray, 0, 14);

 // System.out.print(Arrays.toString(intArray));



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
// }
/**

 public static void quickSort(int[] initialArray, int startIndex, int endIndex) {

 if (startIndex < endIndex) {
 int pi = partitionArray(initialArray, startIndex, endIndex);
 quickSort(initialArray, startIndex, pi - 1);
 quickSort(initialArray, pi + 1, endIndex);
 }
 }

 /**
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

 /**
 public static <T extends Comparable<T>> void quickSort(ArrayList<T> initialArray, int startIndex, int endIndex) {

 if (startIndex < endIndex) {
 int pi = partitionArray(initialArray, startIndex, endIndex);
 quickSort(initialArray, startIndex, pi - 1);
 quickSort(initialArray, pi + 1, endIndex);
 }
 }

 */
/**
 private static <T extends Comparable<T>> int partitionArray(ArrayList<T> arrayToBePartitioned, int startIndex, int endIndex) {
 T pivot = arrayToBePartitioned.get(endIndex);

 int i = startIndex - 1;

 for (int j = startIndex; j < endIndex; j++) {
 if (arrayToBePartitioned.get(endIndex).compareTo(pivot) <= 0) {
 i++;
 T temp = arrayToBePartitioned.get(i);
 arrayToBePartitioned.set(i, arrayToBePartitioned.get(j));
 arrayToBePartitioned.set(j, temp);
 }
 }

 //swap arrayToBePartitioned[i+1] and arrayToBePartitioned[endIndex]

 T temp = arrayToBePartitioned.get(i + 1);
 arrayToBePartitioned.set(i + 1, arrayToBePartitioned.get(endIndex));
 arrayToBePartitioned.set(endIndex, temp);

 return i + 1;
 }

 }

 */

/**

 class LineSegmentBase {

 final int number1;
 final int number2;

 public LineSegmentBase(String twoNumbers) {
 String[] numberArray = twoNumbers.split(" ");
 this.number1 = Integer.parseInt(numberArray[0]);
 this.number2 = Integer.parseInt(numberArray[1]);
 }
 }

 */

/**
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
 return "number1: " + number1 + " number2: " + number2;
 }
 }

 */

/**

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

 */
