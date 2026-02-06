import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    public String readFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            System.err.println("Could not read file: " + e.getMessage());
            return null; 
        }
    }

    public void writeFile(String fileName, String content) {
        try {
            Files.writeString(Path.of(fileName), content);
            System.out.println("Success: Result saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error: Could not write to file. " + e.getMessage());
        }
    }
}
