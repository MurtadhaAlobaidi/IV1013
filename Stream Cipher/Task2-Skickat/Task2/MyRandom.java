import java.util.Random;

public class MyRandom extends Random {
        int a = 16807;//7^5
        int b = 12345678;//
        int m = 2147483647;//2^(31) - 1
        long seed = 0;

        public MyRandom(long seed) {
            setSeed(seed);
        }

        protected int next(int bits) {
            //from lecture Symmetric Key Encryption I
            int x0 = (int) ((a * seed + b) % m);
            seed = x0;
            return x0;
        }

        public synchronized void setSeed(long seed) {
            this.seed = seed;
        }
}
