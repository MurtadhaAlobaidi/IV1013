import java.util.Random;

public class MyRandom extends Random {
    // Task 2
    public int a = 48271;// 48271 C++11's minstd_rand[22]
    public int b = 12345678;//
    public int m = 2147483647;// 2^(31) - 1
    public long seed = 0;

    public MyRandom(long seed) {
        this.setSeed(seed);
    }

    public int next(int bits) {
        int x0 = ((int) ((a * seed + b) % m));
        this.seed = x0;
        return x0;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }
}
