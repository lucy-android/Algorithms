package priority.queue.code.haffman;

import java.util.*;

public class PriorityCode {

    public static void main(String[] args) {

        PriorityQueue<String> pq = new PriorityQueue<>(10, new StringComparator());

        pq.add("aaaa");
        pq.add("bb");
        pq.add("d");
        pq.add("c");

        System.out.println(pq);
        System.out.println(convertStringToLinkedList("sdfsf"));

    }

    public static LinkedList<Character> convertStringToLinkedList(String input) {
        LinkedList<Character> chars = new LinkedList<>();
        for (char letter : input.toCharArray()) {
            chars.add(letter);
        }
        return chars;
    }
}