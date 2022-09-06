package dynamic.programming.max.subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class NotIncreasing {

    public static void main(String[] args) {
        try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberQuantity = Integer.parseInt(bufferReader.readLine());
            String[] numberStrings = bufferReader.readLine().split(" ");
            int[] numbers = new int[numberQuantity];

            for (int i = 0; i < numberQuantity; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            }

            PriorityQueue<Point> queue = createPriorityQueue(numbers);
            Point point = queue.poll();
            List<Integer> list = point.getSubsequenceIndices();
            List<String> stringList = new ArrayList<>(list.size());
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

/*
else if (i == 1) {
        Integer lastElement = pointPriorityQueue.peek().getLastSubsequenceElement();
        if (lastElement >= numbers[i]) {
        LinkedList<Integer> list = pointPriorityQueue.peek().getSubsequence();
        LinkedList<Integer> linkedList = (LinkedList<Integer>) list.clone();

        linkedList.add(numbers[i]);
        Point point = new Point(numbers[i], i, linkedList);
        pointPriorityQueue.add(point);
        } else {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(numbers[i]);
        Point point = new Point(numbers[i], i, linkedList);
        pointPriorityQueue.add(point);
        }
        } else {
        PriorityQueue<Point> mutableQueue = new PriorityQueue<>(pointPriorityQueue);
        while (mutableQueue.size() > 1 && mutableQueue.peek().getLastSubsequenceElement() < numbers[i]) {
        mutableQueue.poll();
        }
        Integer lastElement = mutableQueue.peek().getLastSubsequenceElement();
        if (lastElement >= numbers[i]) {
        LinkedList<Integer> list = mutableQueue.poll().getSubsequence();
        list.add(numbers[i]);
        Point point = new Point(numbers[i], i, list);
        pointPriorityQueue.add(point);
        } else {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(numbers[i]);
        Point point = new Point(numbers[i], i, linkedList);
        pointPriorityQueue.add(point);
        }

        }*/
