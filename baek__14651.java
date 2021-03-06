import java.io.*;
import java.util.*;

class baek__14651 {
    static long[][] d;
    static long r = 1000000009;

    static long go(int n, int m) {
        if (n <= 0)
            return 0;
        if (n == 1) {
            if (m == 0) {
                return 0;
            }
            return 1;
        }

        if (d[n][m] != -1) {
            return d[n][m];
        }

        d[n][m] = go(n - 1, m);
        d[n][m] += go(n - 1, (m + 3 - 2) % 3);
        d[n][m] %= r;
        d[n][m] += go(n - 1, (m + 3 - 1) % 3);
        d[n][m] %= r;

        return d[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d = new long[n + 1][3];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 3; j++) {
                d[i][j] = -1;
            }
        }

        System.out.print(go(n, 0));
    }
}
