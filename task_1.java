import java.io.*;
import java.nio.file.*;

public class FileHandlingUtility {
    private static final String FILE_PATH = "sample.txt";

    // Method to write content to a file
    public static void writeFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("File Contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to append content to a file
    public static void appendFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.newLine();
            writer.write(content);
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }

    // Method to modify a file by replacing a word
    public static void modifyFile(String oldWord, String newWord) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            content = content.replaceAll(oldWord, newWord);
            Files.write(Paths.get(FILE_PATH), content.getBytes());
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeFile("Hello, this is a Java File Handling Program!");
        readFile();
        appendFile("This is an appended line.");
        readFile();
        modifyFile("Java", "Advanced Java");
        readFile();
    }
}
