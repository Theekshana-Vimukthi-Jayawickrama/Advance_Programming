import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SaveStudents {
    public static void main(String[] args) {
        try (BufferedWriter writer =
                     Files.newBufferedWriter(Path.of("students.txt"))) {
            writer.write("19CIS3349,Asha");
            writer.newLine();
            writer.write("20CIS4455,Nimal");
        } catch (IOException e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }
}
