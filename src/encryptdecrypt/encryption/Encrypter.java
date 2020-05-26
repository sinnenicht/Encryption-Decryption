package encryptdecrypt.encryption;

public class Encrypter {
    private EncryptionMethod method;

    public void setMethod(EncryptionMethod method) {
        this.method = method;
    }

    public String encryptString(String string, int key) {
        return this.method.encryptString(string, key);
    }
}
