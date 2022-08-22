package divide.et.conquera.quicksort;

import java.util.Arrays;

class QSort {

    public static void main(String[] args) throws Exception {

        int[] intArray = new int[]{7, 2, 1, 8, 6, 3, 5, 3422, 685, 100, 1, 11, 0, 0, 0};

        // System.out.println(Arrays.toString(partitionArray(intArray, 0, 14)));

        System.out.println(Arrays.toString(partitionArray(
                new int[]{9, 3, 5, 10, 4, 4, 44, 4, 8, 1, 4, 6, 2, 4, 5}, 0, 14)));





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

    public static int[] quickSort(int[] initialArray) {
        // разбираем базовый случай
        if (initialArray.length == 0 || initialArray.length == 1) {
            return initialArray;
        } else if (initialArray.length == 2) {
            if (initialArray[0] >= initialArray[1]) {
                int temp = initialArray[1];
                initialArray[1] = initialArray[0];
                initialArray[0] = temp;
            }
            return initialArray;
        } else {
            // partitionArray(initialArray, )


        }
        return null;


    }

    private static int selectPivotIndex(int[] initialArray, int startIndex, int endIndex) throws Exception {
        if (endIndex > initialArray.length || startIndex > initialArray.length) {
            throw new Exception("Error in the method selectPivotIndex: endIndex > initialArray.length || startIndex > initialArray.length!");
        } else if (endIndex < startIndex) {
            throw new Exception("Error in the method selectPivotIndex: endIndex < startIndex!");
        } else if (startIndex < 0) {
            throw new Exception("Error in the method selectPivotIndex: startIndex<0!");
        } else if (endIndex == startIndex) {
            return initialArray[endIndex];
        } else if (initialArray.length == 1) {
            return 0;
        }

        return initialArray[0];
    }

    private static int[] partitionArray(int[] arrayToBePartitioned, int startIndex, int endIndex) throws Exception {
        if (startIndex > endIndex) {
            throw new Exception("partitionArray error: startIndex>endIndex!");
        } else if (endIndex > arrayToBePartitioned.length - 1) {
            throw new Exception("partitionArray error: endIndex> arrayToBePartitioned.length-1!");
        } else if (startIndex < 0) {
            throw new Exception("partitionArray error: startIndex < 0!");
        }


        if (endIndex - startIndex == 0) {
            return arrayToBePartitioned;
        }

        if (endIndex - startIndex == 1) {
            if (arrayToBePartitioned[startIndex] > arrayToBePartitioned[endIndex]) {
                int temp = arrayToBePartitioned[startIndex];
                arrayToBePartitioned[startIndex] = arrayToBePartitioned[endIndex];
                arrayToBePartitioned[endIndex] = temp;
            }
            return arrayToBePartitioned;

        }


        int i = startIndex - 1;
        int j = startIndex;
        int pivot = selectPivotIndex(arrayToBePartitioned, startIndex, endIndex);

        while (j <= endIndex) {
            if (arrayToBePartitioned[j] < pivot) {
                i++;
                int temp = arrayToBePartitioned[j];
                arrayToBePartitioned[j] = arrayToBePartitioned[i];
                arrayToBePartitioned[i] = temp;
            }
            j++;
        }

        System.out.println("i = " + i);
        System.out.println("j = " + j);

        /**
         * i - последний индекс той части массива, что строго меньше
         * Остальная часть массива больше или равно.
         *
         */


        int[] firstPartReArrangedArray = partitionArray(arrayToBePartitioned, startIndex, i + 1);

        int[] secondPartReArrangedArray = partitionArray(firstPartReArrangedArray, i + 1, endIndex);


        return secondPartReArrangedArray;
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
