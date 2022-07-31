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

    }

}


class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
