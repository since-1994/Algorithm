import java.io.*;
import java.util.*;

class baek__2225 {

    static long remain = 1000000000;
    static long[][] d = new long[201][201];

    static long go(int n, int k) {
        if (k < 0)
            return 0;
        if (n == 0 && k == 0)
            return 1;

        if (d[n][k] != -1) {
            return d[n][k];
        }

        d[n][k] = 0;

        for (int i = 0; i <= n; i++) {
            d[n][k] += go(n - i, k - 1);
            d[n][k] %= remain;
        }

        return d[n][k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                d[i][j] = -1;
            }
        }
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        System.out.print(go(n, k));
    }
}