import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class PKCS1PaddingExample {
    public static void main(String[] args) throws Exception {
        // Generate RSA key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Original message
        String originalMessage = "password";
        System.out.println("Original message: " + originalMessage);

        // Encrypt using PKCS #1 padding
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(originalMessage.getBytes());
        System.out.println("Encrypted bytes: " + new String(encryptedBytes));

        // Decrypt using PKCS #1 padding
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedMessage = new String(decryptedBytes);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}