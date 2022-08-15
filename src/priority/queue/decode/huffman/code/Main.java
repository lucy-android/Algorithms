package priority.queue.decode.huffman.code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String extractedString = extractStringFromFile("C:\\Users\\User\\IdeaProjects\\Algorithms" +
                "\\src\\priority\\queue\\decode\\huffman\\code\\input.txt");
        char[] generalCharArray = extractedString.toCharArray();
        LinkedList<Character> characterList = new LinkedList<>();
        for (char symbol : generalCharArray) {
            characterList.add(symbol);
        }
        Iterator<Character> iterator = characterList.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder numOfDifferentStrings = new StringBuilder();
        while (iterator.hasNext()) {
            char symbol = iterator.next();
            if (symbol == ' ') {
                numOfDifferentStrings.append(stringBuilder);
                // stringBuilder = new StringBuilder();
                break;
            }
            stringBuilder.append(symbol);

        }
        System.out.println("numOfDifferentStrings: " + numOfDifferentStrings);
        String resultString = performAlgorithm(extractedString);
        assert resultString != null;
        writeIntoFile(("C:\\Users\\User\\IdeaProjects\\Algorithms\\src\\priority\\" +
                        "queue\\decode\\huffman\\code\\output.txt"),
                "abacabad");
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

    private static void writeIntoFile(String path, String writtenString) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            byte[] bytes = writtenString.getBytes();
            for (byte bt : bytes) {
                fileOutputStream.write(bt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String performAlgorithm(String extractedString) {
        StringBuilder stringBuilder = new StringBuilder();

        try (FileInputStream fis = new FileInputStream("C:\\Users\\User\\IdeaProjects\\Algorithms" +
                "\\src\\priority\\queue\\decode\\huffman\\code\\input.txt")) {
            int content;

            while ((content = fis.read()) != -1) {
                char castContent = (char) content;
                stringBuilder.append(castContent);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}