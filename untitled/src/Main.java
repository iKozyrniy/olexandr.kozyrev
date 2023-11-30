import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String command = args[0];
        String filePath = args[1];
        int key = Integer.parseInt(args[2]);

        try {
            String fileContent = readFile(filePath);

            String result;
            if (command.equals("ENCRYPT")) {
                result = CaesarCipher.encrypt(fileContent, key);
            } else if (command.equals("DECRYPT")) {
                result = CaesarCipher.decrypt(fileContent, key);
            } else if (command.equals("BRUTE_FORCE")) {
                result = BruteForce.bruteForce(fileContent);
            } else {
                System.out.println("Такої операції не існує.");
                return;
            }

            String methodName = command.toUpperCase();
            String newFileName = getNewFileName(filePath, "[" + methodName + "ED" + "]");
            Path newFilePath = Paths.get(filePath).resolveSibling(newFileName);
            Files.write(newFilePath, result.getBytes());

            System.out.println("Операція була виконана. Був создан новий файл: " + newFilePath);

        } catch (IOException e) {
            System.out.println("Сталася помилка при обробці файла: " + e.getMessage());
        }
    }

    private static String readFile(String filePath) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded);
    }

    private static String getNewFileName(String filePath, String addition) {
        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        String nameWithoutExtension = (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
        String fileExtension = (dotIndex == -1) ? "" : fileName.substring(dotIndex);

        return nameWithoutExtension + addition + fileExtension;
    }
}