import java.io.*;
import java.util.*;

class baek__2293 {
    static int[][] d;
    static int[] coins;

    static int go(int n, int k) {
        if (k < 0)
            return 0;
        if (n <= 0) {
            if (n == 0)
                return 1;
            return 0;
        }

        if (d[n][k] != -1)
            return d[n][k];

        d[n][k] = go(n - coins[k], k) + go(n, k - 1);

        return d[n][k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        d = new int[k + 1][n];
        coins = new int[k];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k + 1; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = -1;
            }
        }

        System.out.print(go(k, n - 1));
    }
}
