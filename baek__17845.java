import java.io.*;
import java.util.*;

class baek__17845 {
    static int[][] d = new int[10001][1000];
    static int[] v;
    static int[] t;

    static int go(int n, int k) {
        if (n <= 0) {
            if (n == 0)
                return 0;
            return -100000000;
        }
        if (k < 0)
            return 0;

        if (d[n][k] != -1)
            return d[n][k];

        d[n][k] = Math.max(go(n, k - 1), go(n - t[k], k - 1) + v[k]);

        return d[n][k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        v = new int[k];
        t = new int[k];
        for (int i = 0; i < k; i++) {
            temp = br.readLine().split(" ");
            v[i] = Integer.parseInt(temp[0]);
            t[i] = Integer.parseInt(temp[1]);
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k; j++) {
                d[i][j] = -1;
            }
        }

        System.out.print(go(n, k - 1));
    }
}
