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
        int numOfDifferentStrings = Integer.parseInt(firstTwoNums[0]);
        int sizeOfTheEncodedString = Integer.parseInt(firstTwoNums[1]);
        HashMap<String, Character> map = new HashMap<>();
        while (stringList.size() > 1) {
            String stringEntry = stringList.poll();
            String[] mapEntry = stringEntry.split(" ");
            map.put(mapEntry[1], mapEntry[0].toCharArray()[0]);
        }
        String encodedString = stringList.poll();
        System.out.println("numOfDifferentStrings: " + numOfDifferentStrings);
        System.out.println("sizeOfTheEncodedString: " + sizeOfTheEncodedString);
        System.out.println("map: " + map);
        System.out.println("encodedString: " + encodedString);



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