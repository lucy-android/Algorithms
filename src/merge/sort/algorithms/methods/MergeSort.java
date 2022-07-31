package merge.sort.algorithms.methods;

import java.util.*;

public class MergeSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int arraySize = scanner.nextInt();
        Queue<Queue<Integer>> generalQueue = new LinkedList<>();

        while (counter < 1) {
            String line = scanner.nextLine();
            if (line.length() != 0) {
                String[] stringArray = line.split(" ");

                for (int i = 0; i < arraySize; i++) {

                    int number = Integer.parseInt(stringArray[i]);

                    Queue<Integer> smallQueue = new LinkedList<>();
                    smallQueue.add(number);

                    generalQueue.add(smallQueue);

                }

                counter++;
            }

        }

        System.out.println(transformQueue(generalQueue, 0));

        scanner.close();

    }

    private static long transformQueue(Queue<Queue<Integer>> initialQueue, long inversionsNumber) {

        int counter = initialQueue.size();
        if (counter < 2) {
            return inversionsNumber;
        }

        while (counter > 1) {
            Queue<Integer> queue1 = initialQueue.poll();
            counter--;
            Queue<Integer> queue2 = initialQueue.poll();
            counter--;
            Map.Entry<Long, Queue<Integer>> entry = mergeTwoSortedQueues(queue1, queue2).entrySet().iterator().next();

            Queue<Integer> newQueue = entry.getValue();
            inversionsNumber += entry.getKey();

            initialQueue.add(newQueue);
        }

        if (counter == 1) {
            Queue<Integer> finalQueue = initialQueue.poll();
            initialQueue.add(finalQueue);
        }

        return transformQueue(initialQueue, inversionsNumber);
    }

    private static HashMap<Long, Queue<Integer>> mergeTwoSortedQueues(Queue<Integer> queue1, Queue<Integer> queue2) {

        Queue<Integer> newQueue = new LinkedList<>();

        long inversionsNumber = 0;

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.isEmpty()) {
                int x = queue2.poll();
                newQueue.add(x);
            } else if (queue2.isEmpty()) {
                int y = queue1.poll();
                newQueue.add(y);
            } else {
                int queue1element = queue1.peek();
                int queue2element = queue2.peek();
                if (queue1element <= queue2element) {
                    newQueue.add(queue1element);
                    queue1.poll();
                } else {
                    newQueue.add(queue2element);
                    queue2.poll();
                    inversionsNumber += queue1.size();
                }
            }
        }

        HashMap<Long, Queue<Integer>> map = new HashMap<>();

        map.put(inversionsNumber, newQueue);

        return map;
    }

}
