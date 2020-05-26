package encryptdecrypt.decryption;

public class Decrypter {
    private DecryptionMethod method;

    public void setMethod(DecryptionMethod method) {
        this.method = method;
    }

    public String decryptString(String string, int key) {
        return this.method.decryptString(string, key);
    }
}
