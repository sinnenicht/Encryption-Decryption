package encryptdecrypt.decryption;

import encryptdecrypt.ShiftCipher;

import static encryptdecrypt.ShiftCipher.getDecryptionShiftCipher;

public class ShiftDecryption implements DecryptionMethod {
    @Override
    public String decryptString(String string, int key) {
        ShiftCipher.setShiftCipher(key);
        char[] message = string.toCharArray();
        int messageLength = message.length;
        for (int index = 0; index < messageLength; index++) {
            if (getDecryptionShiftCipher().containsKey(message[index])) {
                message[index] = getDecryptionShiftCipher().get(message[index]);
            }
        }
        return new String(message);
    }
}
