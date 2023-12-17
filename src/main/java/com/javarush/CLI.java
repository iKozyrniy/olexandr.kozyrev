import java.io.IOException;

public class CLI {

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Неправильна кількість аргументів. Використання: java -jar myApp.jar command filePath key");
            return;
        }

        String command = args[0];
        String filePath = args[1];
        int key = Integer.parseInt(args[2]);

        try {
            String content = FileService.readFile(filePath);

            switch (command.toUpperCase()) {
                case "ENCRYPT":
                    String encryptedContent = CaesarCipher.encrypt(content, key);
                    FileService.writeFile(getOutputFilePath(filePath, "ENCRYPTED"), encryptedContent);
                    break;
                case "DECRYPT":
                    String decryptedContent = CaesarCipher.decrypt(content, key);
                    FileService.writeFile(getOutputFilePath(filePath, "DECRYPTED"), decryptedContent);
                    break;
                case "BRUTE_FORCE":
                    String bruteForceDecryptedContent = CaesarCipher.bruteForceDecrypt(content);
                    FileService.writeFile(getOutputFilePath(filePath, "BRUTE_FORCE_DECRYPTED"), bruteForceDecryptedContent);
                    break;
                default:
                    System.out.println("Невідома команда.");
            }

        } catch (IOException e) {
            System.out.println("Помилка при роботі з файлом: " + e.getMessage());
        }
    }

    private static String getOutputFilePath(String filePath, String operation) {
        // Формування шляху для виведення результату
    }
}