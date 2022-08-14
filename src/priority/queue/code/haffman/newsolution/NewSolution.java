package priority.queue.code.haffman.newsolution;

import java.util.*;

class NewSolution {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            PriorityQueue<Node> pq = transformLineToPriorityQueue(line);
            System.out.print(pq.size() + " ");
            implementingTheAlgorithmLoop(pq);
            assert pq.peek() != null;
            HashMap<Character, String> map = pq.peek().getMappedChildNodes();

            String finalString = generateFinalString(line, map);

            System.out.println(finalString.length());


            for (Map.Entry<Character, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println(finalString);

        }

    }

    private static String generateFinalString(String line, HashMap<Character, String> map) {
        char[] chars = line.toCharArray();
        StringBuilder stringBuilder = new StringBuilder("");
        for (char character : chars) {
            String code = map.get(character);
            stringBuilder.append(code);
        }
        return stringBuilder.toString();
    }

    private static void implementingTheAlgorithmLoop(PriorityQueue<Node> pq) {
        if (pq.size() == 1) {
            Node node = pq.peek();
            LeafNode lf = (LeafNode) node;
            lf.huffManCode.append("0");
            return;
        }
        while (pq.size() > 1) {
            Node lesserNode = pq.poll();
            Node biggerNode = pq.poll();
            lesserNode.updateHuffmanCodeOfAllLeafNodes(true);
            biggerNode.updateHuffmanCodeOfAllLeafNodes(false);
            Node newNode = new ParentNode(lesserNode, biggerNode);
            pq.add(newNode);
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

abstract class Node {

    private int frequency;

    abstract ArrayList<LeafNode> getAllChildNodes();

    public HashMap<Character, String> getMappedChildNodes() {
        HashMap<Character, String> map = new HashMap<>();
        ArrayList<LeafNode> list = getAllChildNodes();
        for (LeafNode leafNode : list) {
            map.put(leafNode.getLetterChar(), leafNode.huffManCode.toString());
        }
        return map;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void updateFrequency() {
        this.frequency++;
    }

    abstract void updateHuffmanCodeOfAllLeafNodes(boolean bool);
}

class LeafNode extends Node {

    public StringBuilder huffManCode = new StringBuilder("");

    @Override
    public String toString() {
        return "LeafNode{" +
                "letterChar=" + letterChar +
                " frequency=" + getFrequency() +
                " huffmanCode=" + huffManCode.toString();
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

    @Override
    void updateHuffmanCodeOfAllLeafNodes(boolean bool) {
        StringBuilder newHuffManCode;
        if (bool) {
            newHuffManCode = new StringBuilder("0");
        } else {
            newHuffManCode = new StringBuilder("1");
        }
        newHuffManCode.append(huffManCode.toString());
        huffManCode = new StringBuilder("");
        huffManCode.append(newHuffManCode);
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

    @Override
    void updateHuffmanCodeOfAllLeafNodes(boolean bool) {
        letterNode.updateHuffmanCodeOfAllLeafNodes(bool);
        biggerNode.updateHuffmanCodeOfAllLeafNodes(bool);
    }

    @Override
    public String toString() {
        return "ParentNode{" +
                "letterNode=" + letterNode +
                ", biggerNode=" + biggerNode;
    }
}

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return -Integer.compare(o2.getFrequency(), o1.getFrequency());
    }
}