package encryptdecrypt;

import java.util.HashMap;
import java.util.Map;

public class ShiftCipher {
    private static Map<Character, Character> encryptionShiftCipher = new HashMap<>(52);
    private static Map<Character, Character> decryptionShiftCipher = new HashMap<>(52);

    public static Map<Character, Character> getEncryptionShiftCipher() {
        return encryptionShiftCipher;
    }
    public static Map<Character, Character> getDecryptionShiftCipher() {
        return decryptionShiftCipher;
    }

    public static void setShiftCipher(int key) {
        // Add lowercase characters to encryption map
        char encryptedCharacter = 'a';
        encryptedCharacter += key;
        for (char currentChar = 'a'; currentChar <= 'z'; currentChar++) {
            encryptionShiftCipher.put(currentChar, encryptedCharacter);
            encryptedCharacter += 1;
            if (encryptedCharacter > 'z') {
                encryptedCharacter = 'a';
            }
        }

        // Add uppercase characters to encryption map
        encryptedCharacter = 'A';
        encryptedCharacter += key;
        for (char currentChar = 'A'; currentChar <= 'Z'; currentChar++) {
            encryptionShiftCipher.put(currentChar, encryptedCharacter);
            encryptedCharacter += 1;
            if (encryptedCharacter > 'Z') {
                encryptedCharacter = 'A';
            }
        }

        // Copy all characters to decryption map
        for (var entry : encryptionShiftCipher.entrySet()) {
            decryptionShiftCipher.put(entry.getValue(), entry.getKey());
        }
    }
}
