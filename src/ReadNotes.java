import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadNotes {
    public static void main(String[] args) {
        Path file = Path.of("notes.txt");
        try {
            String content = Files.readString(file);
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Read failed: "
                    + e.getMessage());
        }
    }
}
