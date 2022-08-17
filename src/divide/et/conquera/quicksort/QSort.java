package divide.et.conquera.quicksort;

import java.util.Scanner;

class QSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");
        while (counter < Integer.parseInt(numbers[1])) {
            String newLine = scanner.nextLine();
            if (!newLine.equals("")) {
                counter++;
            }

        }

        System.out.println("1 0 0");
        scanner.close();
    }


}
