package priority.queue.code.haffman;

import java.util.*;

public class PriorityCode {

    public static void main(String[] args) {

        PriorityQueue<String> pq = new PriorityQueue<>(new StringComparator());

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

    public static LinkedList<FrequencyCharacter> convertStringToFrequencyCharacter(String input){
        LinkedList<FrequencyCharacter> frequencyCharacters = new LinkedList<>();
        for (char letter : input.toCharArray()) {

        }
        return frequencyCharacters;
    }
}