import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteNotes {
    public static void main(String[] args) {
        Path file = Path.of("notes.txt");
        try {
            Files.writeString(file, "Java file handling\n");
            System.out.println("Saved: " + file);
        } catch (IOException e) {
            System.out.println("Write failed: "
                    + e.getMessage());
        }
    }
}
