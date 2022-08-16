package priority.queue.decode.huffman.code;

import java.util.*;

class Main {
    public static void main(String[] args) {

        HashMap<String, Character> map = new HashMap<>();
        StringBuilder encodedString = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] array = firstLine.split(" ");
        int stringCount = Integer.parseInt(array[0]);
        int counter = 0;
        while (counter < stringCount + 1) {
            String line = scanner.nextLine();

            if (line.length() != 0 && counter < stringCount) {
                if (counter >= 0) {
                    String[] splitArray = line.split(" ");
                    String key = splitArray[1];
                    char value = splitArray[0].toCharArray()[0];
                    map.put(key, value);
                }
            } else {
                encodedString.append(line);
            }

            counter++;
        }

        System.out.println(decodeTheString(encodedString.toString(), map));

        scanner.close();
    }

    private static String decodeTheString(String encodedString, HashMap<String, Character> map) {
        char[] charArray = encodedString.toCharArray();
        LinkedList<Character> characterList = new LinkedList<>();
        for (char symbol : charArray) {
            characterList.add(symbol);
        }
        StringBuilder decodedStringBuilder = new StringBuilder();
        StringBuilder codeStringBuilder = new StringBuilder();
        while (characterList.size() > 0) {
            char character = characterList.poll();
            codeStringBuilder.append(character);
            Character encodedSymbol = map.get(codeStringBuilder.toString());
            if (encodedSymbol != null) {
                decodedStringBuilder.append(encodedSymbol);
                codeStringBuilder = new StringBuilder();
            }
        }

        return decodedStringBuilder.toString();
    }
}