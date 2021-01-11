import java.io.*;
import java.util.*;

class baek__10844 {

    static long remain = 1000000000;
    static int MAX = 100;
    static long[][] d = new long[MAX + 1][10];

    static long go(int n, int dec) {
        if (dec < 0 || dec >= 10)
            return 0;
        if (n == 1) {
            if (dec == 0) {
                return 0;
            }
            return 1;
        }

        if (d[n][dec] != -1)
            return d[n][dec];

        d[n][dec] = go(n - 1, dec - 1);
        d[n][dec] %= remain;
        d[n][dec] += go(n - 1, dec + 1);
        d[n][dec] %= remain;

        return d[n][dec];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < MAX + 1; i++) {
            for (int j = 0; j < 10; j++) {
                d[i][j] = -1;
            }
        }

        long ans = 0;

        for (int i = 0; i < 10; i++) {
            ans += go(n, i);
            ans %= remain;
        }

        System.out.print(ans);

    }
}