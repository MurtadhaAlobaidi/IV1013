import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class PasswordCrack {

    static ArrayList<String> temp = new ArrayList<String>();
    static CopyOnWriteArrayList<String> passwordes = new CopyOnWriteArrayList<String>();
    public static char[] lettersArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static BufferedReader getPasswords = null;
    public static BufferedReader getDictionary = null;
    public static String passLetters;
    public static String dictLetters;

    public static void main(String[] args) {
        String dictionary = args[0];
        String passwords = args[1];
        addPass();

        int a = args.length;
        while (a != 2) {
            System.out.println(
                    "This arguments should be as: java PasswordCrack java PasswordCrack <dictionary> <passwd>");
            System.exit(1);
        }

        try {
            getPasswords = new BufferedReader(new FileReader(passwords));
            getDictionary = new BufferedReader(new FileReader(dictionary));

            while ((passLetters = getPasswords.readLine()) != null) {
                String[] splitter = passLetters.split(":");
                String encryptPass = splitter[1];
                String[] names = splitter[4].split(" ");
                passwordes.add(encryptPass);

                if (names.length > 2) {
                    temp.add(names[0]);
                    temp.add(names[names.length - 1]);
                } else {
                    temp.add(names[0]);
                    temp.add(names[1]);
                }
            }

            while ((dictLetters = getDictionary.readLine()) != null) {
                temp.add(dictLetters);
            }
        } catch (IOException e) {
            System.out.println("OBS!!! The argumentes <dictionary> or <passwd>  not exists");
            System.exit(1);
        }
        for (String wordlist : temp) {
            compares(wordlist);
        }
        mangling(temp);
    }

    private static void mangling(ArrayList<String> list) {
        ArrayList<String> mangles = new ArrayList<>();
        ArrayList<String> toDelet = new ArrayList<>();
        temp = null;

        for (String wordlist : list) {
            if (wordlist.length() > 0) {

                mangles.add(compares(reverse(wordlist)));
                mangles.add(compares(reflect2(wordlist)));
                mangles.add(compares(uppercase(wordlist)));
                mangles.add(compares(lowercase(wordlist)));
                mangles.add(compares(capitalize(wordlist)));
                mangles.add(compares(ncapitalize(wordlist)));
                mangles.add(compares(toggle1(wordlist)));
                mangles.add(compares(toggle2(wordlist)));

                try {
                    mangles.add(compares(deleteFirst(wordlist)));
                } catch (Exception e) {
                    toDelet.add(wordlist);
                }
                if (wordlist.length() <= 8) {
                    try {
                        mangles.add(compares(deleteLast(wordlist)));
                    } catch (Exception e) {
                        toDelet.add(wordlist);
                    }
                    mangles.add(compares(duplicate(wordlist)));
                    mangles.add(compares(reflect1(wordlist)));
                }
            }
        }
        list.removeAll(toDelet);

        for (String wordlist : list) {
            for (int q = 0; q < lettersArray.length; q++) {
                compares(prependP(wordlist, q));
            }
            if (wordlist.length() <= 8) {
                for (int q = 0; q < lettersArray.length; q++) {
                    compares(appendA(wordlist, q));
                }
            }
        }
        try {
            mangling(mangles);
        } catch (OutOfMemoryError e) {
            System.exit(0);
        }

    }

    public static String prependP(String wordlist, int p) {
        char character = lettersArray[p];
        return character + wordlist;
    }

    public static String appendA(String wordlist, int a) {
        char character = lettersArray[a];
        return wordlist + character;
    }

    public static String deleteFirst(String wordlist) {
        return wordlist.substring(1);
    }

    public static String deleteLast(String wordlist) {
        return wordlist.substring(0, wordlist.length() - 1);
    }

    public static String reverse(String wordlist) {
        return new StringBuilder(wordlist).reverse().toString();
    }

    public static String duplicate(String wordlist) {
        return wordlist + wordlist;
    }

    public static String reflect1(String wordlist) {
        return wordlist + reverse(wordlist);
    }

    public static String reflect2(String wordlist) {
        return reverse(wordlist) + wordlist;
    }

    public static String uppercase(String wordlist) {
        return wordlist.toUpperCase();
    }

    public static String lowercase(String wordlist) {
        return wordlist.toLowerCase();
    }

    public static String capitalize(String wordlist) {
        return wordlist.substring(0, 1).toUpperCase() + wordlist.substring(1);
    }

    public static String ncapitalize(String wordlist) {
        return wordlist.substring(0, 1).toLowerCase() + wordlist.substring(1).toUpperCase();
    }

    public static String toggle1(String wordlist) {
        String toggle = "";
        for (int i = 0; i < wordlist.length(); i++) {
            if (i % 2 == 0) {
                toggle += wordlist.substring(i, i + 1).toUpperCase();
            } else {
                toggle += wordlist.substring(i, i + 1);
            }
        }
        return toggle;
    }

    public static String toggle2(String wordlist) {
        String toggle = "";
        for (int i = 0; i < wordlist.length(); i++) {
            if (i % 2 != 0) {
                toggle += wordlist.substring(i, i + 1).toUpperCase();
            } else {
                toggle += wordlist.substring(i, i + 1);
            }
        }
        return toggle;
    }

    public static String compares(String wordlist) {

        Iterator<String> iterator = passwordes.iterator();
        while (iterator.hasNext()) {
            String password = iterator.next();
            String compareHashing = jcrypt.crypt(password, wordlist);

            while (passwordes.contains(compareHashing)) {
                System.out.println(wordlist);
                passwordes.remove(compareHashing);
                while (passwordes.isEmpty()) {
                    System.exit(0);
                }
            }
        }
        return wordlist;
    }

    private static void addPass() {
        temp.add("123456");
        temp.add("password");
        temp.add("12345678");
        temp.add("qwerty");
        temp.add("12345");
        temp.add("123456789");
        temp.add("football");
        temp.add("1234");
        temp.add("1234567");
        temp.add("baseball");
        temp.add("welcome");
        temp.add("1234567890");
        temp.add("abc123");
        temp.add("111111");
        temp.add("1qaz2wsx");
        temp.add("dragon");
        temp.add("master");
        temp.add("monkey");
        temp.add("letmein");
        temp.add("login");
        temp.add("princess");
        temp.add("qwertyuiop");
        temp.add("solo");
        temp.add("passw0rd");
        temp.add("starwars");
    }
}