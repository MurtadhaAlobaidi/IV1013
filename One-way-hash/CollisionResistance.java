import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class CollisionResistance {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        System.out.println("\nENTER YOUR MESSAGE TO DIGEST:");
        Scanner scanner = new Scanner(System.in);
        String inputMessage = scanner.nextLine();
        scanner.close();
        byte[] digest = messageDigest(inputMessage);
        bruteForcing(digest);
        System.exit(0);
    }

    public static byte[] messageDigest(String inputDigest) {
        byte[] toDigest = new byte[0];
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(inputDigest.getBytes("UTF-8"));
            toDigest = md.digest();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ALGORITHM " + "SHA-256" + " IS NOT AVAILABLE");
            System.exit(1);
        } catch (UnsupportedEncodingException e) {
            System.out.println("ENCODING " + "UTF-8" + " IS NOT AVAILABLE");
            System.exit(1);
        }
        return toDigest;
    }

    public static void bruteForcing(byte[] digest) throws NoSuchAlgorithmException, IOException {
        byte[] compareToDigest;
        int counter = 0;
        byte[] forceBits;
        System.out.print("\nBRUTE-FORCING...");
        while (true) {
            if (counter % 900000 == 0) {
                System.out.print(".");
            }
            forceBits = ToByteArray(counter);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(forceBits);
            compareToDigest = md.digest();
            counter++;
            if (digest[0] == compareToDigest[0] && digest[1] == compareToDigest[1] && digest[2] == compareToDigest[2]) {
                System.out.println("\n\nIt take " + "[" + counter + "]" + " trials to generate a digest");
                System.out.print("\nORIGINAL DIGEST :       0x");
                for (int i = 0; i < 3; i++)
                    System.out.format("%02x", digest[i] & 0xff);
                System.out.print("\nBRUTE-FORCED DIGEST:    0x");
                for (int i = 0; i < 3; i++)
                    System.out.format("%02x", compareToDigest[i] & 0xff);
                System.out.println("\n");
                System.out.println("\n");
                return;
            }
        }
    }
    
    static byte[] ToByteArray(long counter) throws IOException {
        ByteArrayOutputStream outputArray = new ByteArrayOutputStream();
        new DataOutputStream(outputArray).writeLong(counter);
        new DataOutputStream(outputArray).flush();
        return outputArray.toByteArray();
    }

}


