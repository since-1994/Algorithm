import java.io.*;
import java.util.*;

class baek__2410 {
    static int MAX = 1000000;
    static long r = 1000000000;
    static long[][] d = new long[MAX + 1][21];

    static long go(int n, int m) {
        if (m < 0)
            return 0;
        if (n <= 0) {
            if (n == 0)
                return 1;
            return 0;
        }

        if (d[n][m] != -1)
            return d[n][m];

        d[n][m] = go(n - (1 << m), m) + go(n, m - 1);
        d[n][m] %= r;

        return d[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < MAX + 1; i++) {
            for (int j = 0; j < 21; j++) {
                d[i][j] = -1;
            }
        }

        int n = Integer.parseInt(br.readLine());

        System.out.print(go(n, 20));
    }
}