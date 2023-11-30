public class BruteForce {
    public static String bruteForce(String encryptedText) {
        StringBuilder result = new StringBuilder();
        for (int key = 1; key <= 25; key++) {
            String decryptedText = decrypt(encryptedText, key);
            result.append("Можливе значення ключа ").append(key).append(": ").append(decryptedText).append("\n");
        }
        return result.toString();
    }

    private static String decrypt(String text, int key) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        StringBuilder newText = new StringBuilder();

        for (char letter : text.toCharArray()) {
            if (Character.isLetter(letter)) {
                char decryptedChar = (char) (letter - key);
                if (Character.isUpperCase(letter) && decryptedChar < 'A') {
                    decryptedChar = (char) (decryptedChar + 26);
                } else if (Character.isLowerCase(letter) && decryptedChar < 'a') {
                    decryptedChar = (char) (decryptedChar + 26);
                }
                newText.append(decryptedChar);
            } else {
                newText.append(letter);
            }
        }
        return newText.toString();
    }
}