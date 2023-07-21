import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Cipherwithpadding {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

//        Cipher cipher = Cipher.getInstance("RSA");
//        String plainText = "Pa$$w0rd";
//        String publicKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJwFGcUih7J8ohoVq03albaqUeuzwUNMZtvfUnAdTx5gSh9P03gBMl5YeC99+fg7apilg97qqrZ0a8t5W61Jo3GI1/Sgwzvo11jnA8ojRE+25MJ5zxQumBSYGyCPZDLq7J09C38cq2LazEB2FE06fZ+Sc0qrAMf4gWf2p1C86AWXAgMBAAECgYEAlrQ2mD0qZjYNPrT/q0wgoTkTuGEBpUf/cxLcRn+JFQZdkrFAywIc7RT3wqgk9Kov5RK7tm9mRqdeGEU5UMF4pYg5qtOV31sIAoxbn5OdIeVTXw0zhtskt19rm2eZ9vot0mWcuKKBq2I8uSA6S/YyZsGpQJxW0BUJAMK0imRaGcECQQDH42DqYCrZp2VvSUjL/Y0dEPWdwdSey/iR4IKLDx5uSnx5mJgsVdQwU0y2JGsc0OpCGZAWv3dRNagCZ+XK6z6jAkEAx9E0QNmXgoYtru2a7y55WK6LqxfPmPA8fSRpmA+5NKGPOyd2+OXrb2XJSL00D6P8T0hpUjHuGCJ6UWZItqLQfQJAHrnK+fwSWiarJvIi6IhvGpqyxq822boM2Y+jQXDvgpCclaxpJ9eBqHQFhLIQbPuIJuT7CyQfWTJgQw5pekmy9QJAJKzsd1645Xc1WV85Sd9w3GslLaEwNHUb1ShizUtNhjCFNqlWt/aTkR3QpS49KQXDYNX8pt6NQhbJ9rjcbdFSjQJAYLH3KaIqMU16lmhPhVozitquwNPjdDT0mbGngI4UTXVrbYQs6G15huCVY9wJG6QamlPqLRbE1ysEwLXwjJNTrw==";
//        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
//        String output = Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
//        System.out.println(output);

        String originalString = "Pa$$w0rd";

        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded string (with padding): " + encodedString);

    }

    private static PublicKey getPublicKey(String base64PublicKey) {
        PublicKey publicKey;
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

}
