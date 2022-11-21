import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class PGP {
private PublicKey publicKey;
private PrivateKey privateKey;

public PGP() throws NoSuchAlgorithmException {

    try {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        KeyPair pair = generator.generateKeyPair();
        privateKey = pair.getPrivate();
        publicKey = pair.getPublic();
    } catch (Exception ignored) {
    }

}

    private String encodeToByte(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decodeToByte(String data) {
        return Base64.getDecoder().decode(data);
    }

    public String encrypt(String message) throws Exception{
        byte[] messageToBytes = message.getBytes();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
        return encodeToByte(encryptedBytes);
    }
    public String decrypt(String encryptedMessage) throws Exception{
        byte[] encryptedBytes = decodeToByte(encryptedMessage);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decryptedMessage = cipher.doFinal(encryptedBytes);
        return new String(decryptedMessage,"UTF8");
    }
}
