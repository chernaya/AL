import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class ForPass {


    public static String makeSalt() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    public static String getHash(String str) throws NoSuchAlgorithmException {
        MessageDigest md5;
        StringBuffer hexString = new StringBuffer();

        md5 = MessageDigest.getInstance("md5");
        md5.reset();
        md5.update(str.getBytes());

        byte messageDigest[] = md5.digest();

        for (int i = 0; i < messageDigest.length; i++) {
            hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
        }

        return hexString.toString();
    }
}
