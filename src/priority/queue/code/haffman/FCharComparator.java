package priority.queue.code.haffman;

import java.util.Comparator;

public class FCharComparator implements Comparator<FrequencyCharacter> {

    @Override
    public int compare(FrequencyCharacter o1, FrequencyCharacter o2) {
        return Integer.compare(o2.getFrequency(), o1.getFrequency());
    }
}
