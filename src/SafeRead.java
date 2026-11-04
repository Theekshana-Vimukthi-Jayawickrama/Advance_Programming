import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SafeRead {
    public static void main(String[] args) {
        Path file = Path.of("scores.txt");
        if (Files.notExists(file)) {
            System.out.println("Create scores.txt first.");
            return;
        }
        try {
            System.out.println(Files.readString(file));
        } catch (IOException e) {
            System.out.println("Could not read file: "
                    + e.getMessage());
        }
    }}
