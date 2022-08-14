package priority.queue.code.haffman.newsolution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class NewSolution {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            PriorityQueue<Node> pq = transformLineToPriorityQueue(line);
            System.out.println(pq);
        }

    }

    private static PriorityQueue<Node> transformLineToPriorityQueue(String line) {
        return null;
    }
}

//TODO create class Comparator to compare LeafNodes

abstract class Node {

    private int frequency;

    abstract ArrayList<LeafNode> getAllChildNodes();

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}

class LeafNode extends Node {

    public LeafNode(int frequency) {
        this.setFrequency(frequency);
    }

    @Override
    public ArrayList<LeafNode> getAllChildNodes() {
        ArrayList<LeafNode> leafNodeArrayList = new ArrayList<>();
        leafNodeArrayList.add(this);
        return leafNodeArrayList;
    }
}

class ParentNode extends Node {

    public Node letterNode;
    public Node biggerNode;

    public ParentNode(Node letterNode, Node biggerNode) {
        this.letterNode = letterNode;
        this.biggerNode = biggerNode;
        this.setFrequency(letterNode.getFrequency() + biggerNode.getFrequency());
    }

    @Override
    public ArrayList<LeafNode> getAllChildNodes() {
        ArrayList<LeafNode> firstNodeArrayList = letterNode.getAllChildNodes();
        ArrayList<LeafNode> secondNodeArrayList = biggerNode.getAllChildNodes();
        ArrayList<LeafNode> leafNodeArrayList = new ArrayList<>(firstNodeArrayList);
        leafNodeArrayList.addAll(secondNodeArrayList);
        return leafNodeArrayList;
    }
}

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.getFrequency(), o2.getFrequency());
    }
}