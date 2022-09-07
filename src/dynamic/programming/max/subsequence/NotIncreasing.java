package dynamic.programming.max.subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class NotIncreasing {

    public static void main(String[] args) {
        try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in))) {
            String firstLine = bufferReader.readLine();
            String[] numberStrings = bufferReader.readLine().split(" ");
            int numberStringsLength = numberStrings.length;
            ;
            int[] numbers = new int[numberStringsLength];

            for (int i = 0; i < numberStringsLength; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            }

            PriorityQueue<Point> queue = createPriorityQueue(numbers);
            Point point = queue.poll();
            LinkedList<Integer> list = point.getSubsequenceIndices();
            LinkedList<String> stringList = new LinkedList<>();
            for (int integer : list) {
                stringList.add(String.valueOf(integer));
            }
            System.out.println(list.size());
            System.out.println(String.join(" ", stringList));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static PriorityQueue<Point> createPriorityQueue(int[] numbers) {
        final PriorityQueue<Point> pointPriorityQueue = new PriorityQueue<>(new PointComparator());
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(i + 1);
                Point point = new Point(numbers[i], i, linkedList);
                pointPriorityQueue.add(point);
            } else {
                PriorityQueue<Point> mutableQueue = new PriorityQueue<>(pointPriorityQueue);
                while (mutableQueue.size() > 1 && numbers[mutableQueue.peek().getLastSubsequenceElement() - 1] < numbers[i]) {
                    mutableQueue.poll();
                }
                if (numbers[mutableQueue.peek().getLastSubsequenceElement() - 1] < numbers[i]) {
                    LinkedList<Integer> linkedList = new LinkedList<>();
                    linkedList.add(i + 1);
                    Point point = new Point(numbers[i], i, linkedList);
                    pointPriorityQueue.add(point);
                } else {
                    Point point = mutableQueue.poll();
                    LinkedList<Integer> list = point.getSubsequenceIndices();
                    LinkedList<Integer> linkedList = (LinkedList<Integer>) list.clone();
                    linkedList.add(i + 1);
                    Point newPoint = new Point(numbers[i], i, linkedList);
                    pointPriorityQueue.add(newPoint);
                }
            }
        }
        return pointPriorityQueue;
    }

}


class Point {

    private int value;
    private int index;
    private LinkedList<Integer> subsequenceIndices;

    private Integer lastSubsequenceElement;

    Point(int value, int index, LinkedList<Integer> subsequenceIndices) {
        this.value = value;
        this.index = index;
        this.subsequenceIndices = subsequenceIndices;
        this.lastSubsequenceElement = subsequenceIndices.peekLast();
    }

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    public Integer getLastSubsequenceElement() {
        return lastSubsequenceElement;
    }

    public LinkedList<Integer> getSubsequenceIndices() {
        return subsequenceIndices;
    }
}

class PointComparator implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        return Integer.compare(o2.getSubsequenceIndices().size(), o1.getSubsequenceIndices().size());
    }
}