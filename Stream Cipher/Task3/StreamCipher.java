import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StreamCipher {

    static long key = 0;
    static FileInputStream input = null;
    static FileOutputStream output = null;

    public static void main(String[] args) {

        String infile = args[1];
        String outfile = args[2];

        while (args.length != 3) {
            System.out.println("StreamCipher <key> <infile> <outfile>");
            System.exit(1);
        }

        try {
            key = Long.parseLong(args[0]);
        } catch (Exception e) {
            System.err.println("Key are invalid");
            System.exit(1);
        }

        try {
            input = new FileInputStream(infile);
            output = new FileOutputStream(outfile);
        } catch (Exception e) {
            System.err.println("There are no Input fil");
            System.exit(1);
        }
        // Task2 and 3
        MyRandom prng = new MyRandom(key);
        // Task1
        // Random prng = new Random(key);
        try {
            for (int i = input.read(); i != -1;) {
                int readOtput = i ^ prng.next(8);
                output.write(readOtput);
                i = input.read();
            }
            input.close();
            output.flush();
            output.close();
        } catch (Exception e) {
            System.err.println("ERROR on output data");
            System.exit(1);
        }
        System.exit(0);
    }
}
