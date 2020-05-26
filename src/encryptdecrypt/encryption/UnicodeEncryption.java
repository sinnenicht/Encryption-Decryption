package encryptdecrypt.encryption;

public class UnicodeEncryption implements EncryptionMethod {
    @Override
    public String encryptString(String string, int key) {
        char[] message = string.toCharArray();
        int messageLength = message.length;
        for (int index = 0; index < messageLength; index++) {
            message[index] += key;
        }
        return new String(message);
    }
}
