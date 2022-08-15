package priority.queue.decode.huffman.code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String readString = readFile();
        assert readString != null;
        writeIntoFile(("C:\\Users\\User\\IdeaProjects\\Algorithms\\src\\priority\\" +
                        "queue\\decode\\huffman\\code\\output.txt"),
                "abacabad");
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

    private static String readFile() {
        StringBuilder stringBuilder = new StringBuilder();

        try (FileInputStream fis = new FileInputStream("C:\\Users\\User\\IdeaProjects\\Algorithms" +
                "\\src\\priority\\queue\\decode\\huffman\\code\\input.txt")) {
            int content;
            // reads a byte at a time, if it reached end of the file, returns -1
            while ((content = fis.read()) != -1) {
                char castContent = (char) content;
                System.out.print(castContent);
                stringBuilder.append(castContent);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}