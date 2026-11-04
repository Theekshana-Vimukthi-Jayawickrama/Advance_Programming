import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeleteFile {

    public static void main(String[] args) {
        Path file = Path.of("notes2.txt");
        try {
            Files.delete(file);
            System.out.println("File deleted successfully.");

        } catch (IOException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }
}