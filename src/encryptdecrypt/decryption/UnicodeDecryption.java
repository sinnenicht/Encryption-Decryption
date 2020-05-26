package encryptdecrypt.decryption;

public class UnicodeDecryption implements DecryptionMethod {
    @Override
    public String decryptString(String string, int key) {
        char[] message = string.toCharArray();
        int messageLength = message.length;
        for (int index = 0; index < messageLength; index++) {
            message[index] -= key;
        }
        return new String(message);
    }
}
