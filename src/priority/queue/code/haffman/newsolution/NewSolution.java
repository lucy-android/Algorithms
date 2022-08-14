package priority.queue.code.haffman.newsolution;

import java.util.*;

class NewSolution {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            PriorityQueue<Node> pq = transformLineToPriorityQueue(line);
            System.out.println(pq);
        }

    }

    private static PriorityQueue<Node> transformLineToPriorityQueue(String line) {
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>(new NodeComparator());
        List<LeafNode> leafNodes = new LinkedList<>();
        char[] charArray = line.toCharArray();
        for (char character : charArray) {
            LeafNode leafNode = getLeafNode(leafNodes, character);
            if (leafNode != null) {
                leafNode.updateFrequency();
            } else {
                LeafNode leafNode1 = new LeafNode(character);
                leafNodes.add(leafNode1);
            }

        }

        nodePriorityQueue.addAll(leafNodes);

        return nodePriorityQueue;
    }

    public static LeafNode getLeafNode(List<LeafNode> leafNodes, char letter) {
        for (LeafNode leafNode : leafNodes) {
            char letterChar = leafNode.getLetterChar();
            if (letterChar == letter) {
                return leafNode;
            }
        }
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

    public void updateFrequency() {
        this.frequency++;
    }
}

class LeafNode extends Node {

    @Override
    public String toString() {
        return "LeafNode{" +
                "letterChar=" + letterChar +
                " frequency=" + getFrequency();
    }

    private char letterChar;

    public LeafNode(char letterChar) {
        this.letterChar = letterChar;
        this.setFrequency(1);
    }

    @Override
    public ArrayList<LeafNode> getAllChildNodes() {
        ArrayList<LeafNode> leafNodeArrayList = new ArrayList<>();
        leafNodeArrayList.add(this);
        return leafNodeArrayList;
    }

    public char getLetterChar() {
        return letterChar;
    }

    public void setLetterChar(char letterChar) {
        this.letterChar = letterChar;
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