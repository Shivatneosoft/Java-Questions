import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordCracker5Digit {
    private static String encrypted = "6b51d431df5d7f141cbececcf79edf3dd861c3b4069f0b11661a3eefacbba918";
    private static String[] inputArray = {"1","2","3","4","5","6","7","8","9","0"};

    public static void main(String[] args){
        int lenght = 3;
        int count = 0;
        System.out.println(encrypted);
        try {
            System.out.println(password(lenght,count));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String password(int lenght, int count) {
        int internalCount = count;
        for (internalCount = count; internalCount <= lenght; internalCount++){
            System.out.println(count);
            return password(lenght,internalCount+1);
        }
        return null;
    }

    private static String password() throws NoSuchAlgorithmException {
        for (int i = 0; i < inputArray.length; i++) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(inputArray[i].getBytes(StandardCharsets.UTF_8));
            String encoded = bytesToHex(hash);
            if(encoded.equals(encrypted))
                return "The password is " + inputArray[i];
        }
        return null;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
