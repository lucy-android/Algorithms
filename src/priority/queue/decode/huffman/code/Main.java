package priority.queue.decode.huffman.code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String extractedString = extractStringFromFile("C:\\Users\\User\\IdeaProjects\\Algorithms" +
                "\\src\\priority\\queue\\decode\\huffman\\code\\input.txt");

        assert extractedString != null;
        String[] strings = extractedString.split("\r\n");
        LinkedList<String> stringList = new LinkedList<>(Arrays.asList(strings));
        String firstString = stringList.poll();
        assert firstString != null;
        String[] firstTwoNums = firstString.split(" ");
        int numOfDifferentSymbols = Integer.parseInt(firstTwoNums[0]);
        int sizeOfTheEncodedString = Integer.parseInt(firstTwoNums[1]);
        HashMap<String, Character> map = new HashMap<>();
        while (stringList.size() > 1) {
            String stringEntry = stringList.poll();
            String[] mapEntry = stringEntry.split(" ");
            map.put(mapEntry[1], mapEntry[0].toCharArray()[0]);
        }
        String encodedString = stringList.poll();
        System.out.println("numOfDifferentSymbols: " + numOfDifferentSymbols);
        System.out.println("sizeOfTheEncodedString: " + sizeOfTheEncodedString);
        System.out.println("map: " + map);
        System.out.println("encodedString: " + encodedString);
        decodeTheString(numOfDifferentSymbols, encodedString, map);


        writeIntoFile(("C:\\Users\\User\\IdeaProjects\\Algorithms\\src\\priority\\" +
                        "queue\\decode\\huffman\\code\\output.txt"),
                "abacabad");
    }

    private static String decodeTheString(int numOfDifferentSymbols, String encodedString, HashMap<String, Character> map) {
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
                decodedStringBuilder.append(encodedString);
                codeStringBuilder = new StringBuilder();
            }
        }
        System.out.println(decodedStringBuilder);


        return null;
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