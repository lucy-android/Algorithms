package divide.et.conquera.quicksort;

import java.util.Arrays;

class QSort {

    public static void main(String[] args) {

        int[] intArray = new int[]{7, 2, 1, 8, 6, 3, 5, 4};
        System.out.println(Arrays.toString(partitionArray(intArray, 4, 0, 7)));
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


    /**
     * TODO
     * в конце обхода i должно соответствовать индексу, который примет опорный элемент минус 1.
     * j - конец массива.
     * Начальные значения элементов
     */
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
            int pivot = selectPivotIndex(initialArray);


        }
        return null;


    }

    private static int selectPivotIndex(int[] initialArray) {
        int sumOfElements = 0;
        for (int element : initialArray) {
            sumOfElements += element;
        }
        int position = -1;
        int average = sumOfElements / initialArray.length;
        int closestToAverage = -1;

        for (int i = 0; i < initialArray.length; i++) {
            if (Math.abs(average - closestToAverage) > Math.abs(average - initialArray[i])) {
                closestToAverage = initialArray[i];
                position = i;
            }
        }

        return position;
    }

    private static int[] partitionArray(int[] arrayToBePartitioned, int pivot, int startIndex, int endIndex) {
        int i = -1;
        int j = startIndex;

        while (j <= endIndex) {
            if (arrayToBePartitioned[j] >= pivot) {
                //do nothing
            } else {
                i++;
                int temp = arrayToBePartitioned[j];
                arrayToBePartitioned[j] = arrayToBePartitioned[i];
                arrayToBePartitioned[i] = temp;
            }
            j++;
        }

        return arrayToBePartitioned;
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
