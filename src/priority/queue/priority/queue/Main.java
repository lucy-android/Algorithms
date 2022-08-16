package priority.queue.priority.queue;

import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = scanner.nextInt();
        int counter = 0;
        LinkedList<OperationType> operationTypeLinkedList = new LinkedList<>();

        while (counter < numLines) {

            String insertString = scanner.nextLine();
            if (!Objects.equals(insertString, "")) {
                operationTypeLinkedList.add(operationTypeAbstractFactory(insertString));
                counter++;
            }
        }


        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(new IntegerComparator());
        //TODO subject new priorityQueue to the operations from the list

        while (operationTypeLinkedList.size() > 0) {
            OperationType type = operationTypeLinkedList.poll();
            if (type instanceof Insert) {
                int realNumber = ((Insert) type).number;
                integerPriorityQueue.add(realNumber);
            } else if (type instanceof ExtractMax) {
                System.out.println(integerPriorityQueue.peek());
            }

        }


        scanner.close();


    }

    public static OperationType operationTypeAbstractFactory(String inputString) {
        if (inputString.startsWith("Insert")) {
            String[] splitInsertString = inputString.split(" ");
            return new Insert(Integer.parseInt(splitInsertString[1]));
        } else {
            return new ExtractMax();
        }
    }

    private static class IntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }
}

abstract class OperationType {

}

class ExtractMax extends OperationType {

}


class Insert extends OperationType {
    int number;

    public Insert(int number) {
        this.number = number;
    }
}
