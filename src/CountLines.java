import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CountLines {
    public static void main(String[] args) {

        int count = 0;

        try (BufferedReader reader = Files.newBufferedReader(Path.of("notes.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
                count++;
            }

            System.out.println("Lines: " + count);

        } catch (IOException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }
}