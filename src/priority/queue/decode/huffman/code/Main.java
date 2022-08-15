package priority.queue.decode.huffman.code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        StringBuilder firstString = new StringBuilder();
        HashMap<String, Character> map = new HashMap<>();
        StringBuilder encodedString = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] array = firstLine.split(" ");
        int stringCount = Integer.parseInt(array[0]);
        int counter = 0;
        while (counter < stringCount + 1) {
            String line = scanner.nextLine();

            if (line.length() != 0) {
                if (counter == 0) {
                    firstString.append(line);
                } else if (counter > 0 && counter < stringCount - 1) {
                    String[] splitArray = line.split(": ");
                    String key = splitArray[1];
                    char value = splitArray[0].toCharArray()[0];
                    map.put(key, value);
                } else {
                    encodedString.append(line);
                }
            }

            counter++;
        }

        System.out.println(firstString);

        System.out.println(decodeTheString(encodedString.toString(), map));
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

    private static String extractStringFromFile(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int content;
            StringBuilder stringBuilder = new StringBuilder();

            while ((content = fileInputStream.read()) != -1) {
                char castContent = (char) content;
                stringBuilder.append(castContent);
            }
            return stringBuilder.toString();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private static void writeIntoFile(String path, String resultingString) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            byte[] bytes = resultingString.getBytes();
            for (byte bt : bytes) {
                fileOutputStream.write(bt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}