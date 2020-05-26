package encryptdecrypt.encryption;

import encryptdecrypt.ShiftCipher;

import static encryptdecrypt.ShiftCipher.getEncryptionShiftCipher;

public class ShiftEncryption implements EncryptionMethod {
    @Override
    public String encryptString(String string, int key) {
        ShiftCipher.setShiftCipher(key);
        char[] message = string.toCharArray();
        int messageLength = message.length;
        for (int index = 0; index < messageLength; index++) {
            if (getEncryptionShiftCipher().containsKey(message[index])) {
                message[index] = getEncryptionShiftCipher().get(message[index]);
            }
        }
        return new String(message);
    }
}
