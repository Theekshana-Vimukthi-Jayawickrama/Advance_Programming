import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadStudentsBufferedReader {

    public static void main(String[] args) {

        try (BufferedReader reader =
                     Files.newBufferedReader(Path.of("students.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }
}