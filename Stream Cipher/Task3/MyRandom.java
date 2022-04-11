import java.util.Random;

public class MyRandom extends Random {
    // Task3
    public int a;
    public int b;
    public long seed = 0;
    public int j = 0;
    public int tmp;
    public byte[] keys;
    public int[] S = new int[256];
    public int swapValues;

    public MyRandom(long seed) {
        this.setSeed(seed);
        this.RC4();
    }

    private void RC4() {
        keys = (seed + "").getBytes();
        // From lecturer "SymmetricKeyEncryption Iv3"
        for (int i = 0; i < 256; i++) {
            S[i] = i;
        }
        for (int i = 0; i < 256; i++) {
            j = (j + S[i] + keys[i % keys.length]) % 256;
            tmp = S[i];
            S[i] = S[j];
            S[j] = tmp;
        }
    }

    public int next(int bits) {
        a = ((a + 1) % 256);
        b = (b + S[a]) % 256;
        swapValues = S[a];
        S[a] = S[b];
        S[b] = swapValues;
        return S[(S[a] + S[b]) % 256];
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

}
