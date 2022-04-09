import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StreamCipher {

    static Integer key = 0;
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
            key = Integer.parseInt(args[0]);
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

        try {
            for (int i = input.read(); i != -1;) {
                int readOutput = i;
                output.write(readOutput);
                i = input.read();
            }

            input.close();
            output.close();
        } catch (Exception e) {
            System.err.println("ERROR on output data");
            System.exit(1);
        }
        System.exit(0);
    }
}
