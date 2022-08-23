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
