import java.io.*;
import java.util.*;

class baek__11057 {

    static long remain = 10007;
    static int MAX = 1000;
    static long[][] d = new long[MAX + 1][10];

    static long go(int n, int lastNumber) {
        if (d[n][lastNumber] != -1)
            return d[n][lastNumber];

        if (n == 1)
            return 1;

        d[n][lastNumber] = 0;

        for (int i = 0; i < 10; i++) {
            if (i > lastNumber)
                continue;
            d[n][lastNumber] += go(n - 1, i);
            d[n][lastNumber] %= remain;
        }

        return d[n][lastNumber];

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