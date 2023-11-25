public class CaesarCipher {

    public static String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                encryptedText.append((char) ((ch - base + key) % 26 + base));
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String text, int key) {
        return encrypt(text, 26 - key); // Використовуємо той самий метод, але з іншим ключем
    }

    public static String bruteForceDecrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (int key = 0; key < 26; key++) {
            result.append(String.format("Key %d: %s%n", key, decrypt(text, key)));
        }
        return result.toString();
    }
}
