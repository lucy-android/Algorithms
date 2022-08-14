package priority.queue.code.haffman;

import java.util.*;

public class PriorityCode {

    public static void main(String[] args) {

        PriorityQueue<FrequencyCharacter> characterPriorityQueue = new PriorityQueue<>(30, new FCharComparator());
        List<FrequencyCharacter> characterList = convertStringToFrequencyCharacterList("abacabad");

        characterPriorityQueue.addAll(characterList);

        ArrayList<FrequencyCharacter> listFrequency = new ArrayList<>();

        while (characterPriorityQueue.size() > 0) {
            listFrequency.add(characterPriorityQueue.poll());
        }

        for (int i = 0; i < listFrequency.size(); i++) {
            FrequencyCharacter frequencyCharacter = listFrequency.get(i);
            if (i < listFrequency.size() - 1) {
                frequencyCharacter.setHaffmanCode(createHaffmanCode(i, listFrequency.size()));
            }
        }

        System.out.println(listFrequency);

    }

    private static String createHaffmanCode(int i, int totalLength) {
        StringBuilder stringBuilder = new StringBuilder("");
        int counter = 0;
        while (counter < i) {
            stringBuilder.append("1");
            counter++;
        }
        if (stringBuilder.toString().length() < totalLength - 1) {
            stringBuilder.append("0");
        }

        return stringBuilder.toString();
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