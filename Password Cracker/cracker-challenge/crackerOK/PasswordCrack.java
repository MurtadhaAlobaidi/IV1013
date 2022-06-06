import java.io.*;
import java.lang.*;
import java.util.*;

public class PasswordCrack {

    public static BufferedReader passwords;
    public static BufferedReader dictionary;

    public static LinkedList<String> encryptedPassword = new LinkedList<String>();
    public static LinkedList<String> dictionaryWords = new LinkedList<String>();

    public static LinkedList<String> Hashingswords = new LinkedList<String>();

    public static void main(String[] args) {

        if (args.length < 2) {
            System.err.println(
                    "This arguments should be as: java PasswordCrack java PasswordCrack <dictionary> <passwd>");
            System.exit(1);
        }

        String dictionary = args[0];
        String passwords = args[1];

        // To get all passwords from passwordsFil
        inputpasswords(passwords);
        // System.out.println("\n" + encryptedPassword);

        // To get all wordes from dictionary
        inputDict(dictionary);
        // System.out.println(dictionaryWords);

        list(dictionary);
        // System.out.println(Hashingswords);

    }

    // To read from passwords file
    public static void inputpasswords(String passwords) {
        try {
            // encryptedPassword = new LinkedList<String>();
            BufferedReader x = new BufferedReader(new FileReader(passwords));
            String row = x.readLine();

            // Read from passwd1 file and tags password
            while (row != null) {
                // encryptedPassword.add(row);
                String[] listespilet = row.split(":");
                String passwordlistes = listespilet[1];
                encryptedPassword.add(passwordlistes);
                row = x.readLine();
                continue;
            }

        } catch (IOException e) {
            System.out.println("OBS!!! The argumentes <passwd>  not exists");
            System.exit(1);
        }

    }

    // To read from dictionary
    public static void inputDict(String dictionary) {
        try {
            // dictionaryWords = new LinkedList<String>();
            BufferedReader z = new BufferedReader(new FileReader(dictionary));
            String rowdict = z.readLine();

            while (rowdict != null) {
                dictionaryWords.add(rowdict);
                rowdict = z.readLine();
            }

            dictionaryWords.add("BOB");
            dictionaryWords.add("GEOFFREY");
            dictionaryWords.add("HORATIO");
            dictionaryWords.add("WOLF");
            dictionaryWords.add("LIONEL");
            dictionaryWords.add("ARABELLA");
            dictionaryWords.add("FRANK");
            dictionaryWords.add("SAMMY");
            dictionaryWords.add("QUINCY");
            dictionaryWords.add("ANTONIO");
            dictionaryWords.add("PETER");
            dictionaryWords.add("SUZANNA");
            dictionaryWords.add("GEORGE");
            dictionaryWords.add("EMMANUEL");
            dictionaryWords.add("RUFUS");
            dictionaryWords.add("HARRY");
            dictionaryWords.add("SAM");
            dictionaryWords.add("BENJAMIN");
            dictionaryWords.add("ROSA");
            dictionaryWords.add("RONALD");

            dictionaryWords.add("bob");
            dictionaryWords.add("geoffrey");
            dictionaryWords.add("horatio");
            dictionaryWords.add("wolf");
            dictionaryWords.add("lionel");
            dictionaryWords.add("arabella");
            dictionaryWords.add("frank");
            dictionaryWords.add("sammy");
            dictionaryWords.add("quincy");
            dictionaryWords.add("antonio");
            dictionaryWords.add("peter");
            dictionaryWords.add("suzanna");
            dictionaryWords.add("george");
            dictionaryWords.add("emmanuel");
            dictionaryWords.add("rufus");
            dictionaryWords.add("harry");
            dictionaryWords.add("sam");
            dictionaryWords.add("benjamin");
            dictionaryWords.add("rosa");
            dictionaryWords.add("ronald");

            dictionaryWords.add("Roland");
            dictionaryWords.add("Spaulding");
            dictionaryWords.add("Jamison");
            dictionaryWords.add("Flywheel");
            dictionaryWords.add("Devereaux");
            dictionaryWords.add("Rittenhouse");
            dictionaryWords.add("Wagstaff");
            dictionaryWords.add("Brown");
            dictionaryWords.add("Wagstaff");
            dictionaryWords.add("Pirelli");
            dictionaryWords.add("Minuit");
            dictionaryWords.add("Dukesbury");
            dictionaryWords.add("Schmidlap");
            dictionaryWords.add("Ravelli");
            dictionaryWords.add("Firefly");
            dictionaryWords.add("Binelli");
            dictionaryWords.add("Grunion");
            dictionaryWords.add("Linn");
            dictionaryWords.add("Castaldi");
            dictionaryWords.add("Kornblow");

            dictionaryWords.add("SPAULDING");
            dictionaryWords.add("JAMISON");
            dictionaryWords.add("FLYWHEEL");
            dictionaryWords.add("DEVEREAUX");
            dictionaryWords.add("RITTENHOU");
            dictionaryWords.add("WAGSTAFF");
            dictionaryWords.add("BROWN");
            dictionaryWords.add("WAGSTAFF");
            dictionaryWords.add("PIRELLI");
            dictionaryWords.add("MINUIT");
            dictionaryWords.add("DUKESBURY");
            dictionaryWords.add("SCHMIDLAP");
            dictionaryWords.add("RAVELLI");
            dictionaryWords.add("FIREFLY");
            dictionaryWords.add("BINELLI");
            dictionaryWords.add("GRUNION");
            dictionaryWords.add("LINN");
            dictionaryWords.add("CASTALDI");
            dictionaryWords.add("KORNBLOW");

            dictionaryWords.add("123456");
            dictionaryWords.add("password");
            dictionaryWords.add("12345678");
            dictionaryWords.add("qwerty");
            dictionaryWords.add("12345");
            dictionaryWords.add("123456789");
            dictionaryWords.add("football");
            dictionaryWords.add("1234");
            dictionaryWords.add("1234567");
            dictionaryWords.add("baseball");
            dictionaryWords.add("welcome");
            dictionaryWords.add("1234567890");
            dictionaryWords.add("abc123");
            dictionaryWords.add("111111");
            dictionaryWords.add("1qaz2wsx");
            dictionaryWords.add("dragon");
            dictionaryWords.add("master");
            dictionaryWords.add("monkey");
            dictionaryWords.add("letmein");
            dictionaryWords.add("login");
            dictionaryWords.add("princess");
            dictionaryWords.add("qwertyuiop");
            dictionaryWords.add("solo");
            dictionaryWords.add("passw0rd");
            dictionaryWords.add("starwars");

        } catch (IOException e) {
            System.out.println("OBS!!! The argumentes <dictionary> not exists");
            System.exit(1);
        }
    }

    public static void list(String dictionary) {

        Iterator<String> dictlista = dictionaryWords.iterator();

        while (dictlista.hasNext()) {
            String l = dictlista.next();

            Iterator<String> saltpass = encryptedPassword.iterator();
            while (saltpass.hasNext()) {

                String paslista = saltpass.next();
                String hashingDict = jcrypt.crypt(paslista, l);

                if (encryptedPassword.contains(hashingDict)) {
                    System.out.println(l);
                    Hashingswords.add(l);
                }
            }
            // System.out.println(l);
        }
    }

}
