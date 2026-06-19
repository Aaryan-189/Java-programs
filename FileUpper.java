import java.nio.file.Files;
import java.nio.file.Path;

public class FileUpper {
    public static void main(String[] args) {
        Path path = Path.of("sample.txt");
        
        try {
            // Read all content from the file into a string
            String content = Files.readString(path);
            
            // Convert to uppercase and write it back to the same file
            Files.writeString(path, content.toUpperCase());
            
            System.out.println("File successfully converted to uppercase.");
            
        } catch (Exception e) {
            System.out.println("An error occurred with the file: " + e.getMessage());
        }
    }
}