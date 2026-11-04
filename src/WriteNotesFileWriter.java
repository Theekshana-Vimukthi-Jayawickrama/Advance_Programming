import java.io.FileWriter;
import java.io.IOException;

public class WriteNotesFileWriter {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("notes2.txt");
            writer.write("Java file handling\n");
            writer.write("This is FileWriter.");
            writer.close();

            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Write failed: " + e.getMessage());
        }
    }
}
