import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateFile {
    public static void main(String[] args) throws IOException {

//        Path path = Path.of("notes.txt");
//
//        try {
//            Files.createFile(path);
//            System.out.println("File created successfully!");
//
//        } catch (IOException e) {
//            System.out.println("Error: " + e.getMessage());
//        }

        Path file = Path.of("notes.txt");
        System.out.println("absolute path: " + file.toAbsolutePath());
        System.out.println("Exists: " + Files.exists(file));
        System.out.println("Is file: " + Files.isRegularFile(file));
        System.out.println("File size: " + Files.size(file));
        System.out.println("Last modified: " + Files.getLastModifiedTime(file));
        System.out.println("Is readable: " + Files.isReadable(file));

    }
}