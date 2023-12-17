import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    public static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }

    public static void writeFile(String filePath, String content) throws IOException {
        Path path = Paths.get(filePath);
        Files.write(path, content.getBytes());
    }
}