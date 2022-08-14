package priority.queue.code.haffman;

import java.util.*;

public class PriorityCode {

    public static void main(String[] args) {

        PriorityQueue<FrequencyCharacter> characterPriorityQueue = new PriorityQueue<>(30, new FCharComparator());
        List<FrequencyCharacter> characterList = convertStringToFrequencyCharacterList("abacabad");

        characterPriorityQueue.addAll(characterList);

        LinkedList<FrequencyCharacter> listFrequency = new LinkedList<>();

        while (characterPriorityQueue.size() > 0) {
            listFrequency.add(characterPriorityQueue.poll());
        }

        System.out.println(listFrequency);

    }

    public static List<FrequencyCharacter> convertStringToFrequencyCharacterList(String input) {
        List<FrequencyCharacter> frequencyCharacters = new LinkedList<>();
        for (char letter : input.toCharArray()) {
            FrequencyCharacter fChar = getFrequencyChar(frequencyCharacters, letter);
            if (fChar != null) {
                fChar.upGradeFrequency();
            } else {
                frequencyCharacters.add(new FrequencyCharacter(letter));
            }
        }
        return frequencyCharacters;
    }

    public static FrequencyCharacter getFrequencyChar(List<FrequencyCharacter> frequencyCharacters, char letter) {
        for (FrequencyCharacter fCharacter : frequencyCharacters) {
            if (fCharacter.character == letter) {
                return fCharacter;
            }
        }
        return null;
    }
}