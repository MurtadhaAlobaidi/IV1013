import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Counter {

    public static void main(String[] args) {

        File inputBits1 = new File(args[0]);
        File inputBits2 = new File(args[1]);
        int length = (int) inputBits2.length();
        int j = 0;
        int readBits;

        while (args.length != 2) {
            System.out.println("COUNTER BITS <H1> <H2>");
            System.exit(1);
        }
        try (InputStream input1 = new FileInputStream(inputBits1);
             InputStream input2 = new FileInputStream(inputBits2)) {
            byte[] outputBits1 = new byte[length];
            byte[] outputBits2 = new byte[length];


            readBits = input2.read(outputBits2);

            while ((readBits = input1.read(outputBits1)) != -1) {
                int i = 0;
                while ((i < length)) {
                    if (outputBits1[i] == outputBits2[i]) {
                        j++;
                    }
                    System.out.println(j);
                    i++;
                }
            }
            input1.close();
            input2.close();
            System.exit(0);

        } catch (IOException exception) {
            System.out.println("ERROR!!! CAN NOT READ INPUT FILE");
            System.exit(1);
        }
    }
}
