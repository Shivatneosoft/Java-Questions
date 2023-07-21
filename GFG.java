import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GFG implements Callable<Boolean> {

    Logger logger = Logger.getLogger("GFG.class");

    private static String encrypted = "a815eaee566f993e1413aaee8874587c66729d006180c5ce29c67e8f79daabb24";
    private static String[] inputArray = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                                          "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                                          "1","2","3","4","5","6","7","8","9","0"};

    private static int n = inputArray.length;
    private static boolean result = false;

    private String prefix;
    private int lenght;

    public GFG(String prefix, int lenght) {
        this.prefix = prefix;
        this.lenght = lenght;
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


    @Override
    public Boolean call() throws Exception {
        if (lenght == 0)
        {
            MessageDigest digest = null;
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            byte[] hash = digest.digest(prefix.getBytes(StandardCharsets.UTF_8));
            String encoded = bytesToHex(hash);
            logger.info(prefix);
            if(encoded.equals(encrypted)) {
                logger.info("Password is " + prefix);
                System.exit(0);
                return true;
            }
            return false;
        }

        else {
            GFG gfg1 = null;
            for (int i = 0; i < n; i++){
                gfg1 = new GFG(prefix + inputArray[i], lenght - 1);
                result = gfg1.call() | result;
            }
            return result;
        }
    }
}
