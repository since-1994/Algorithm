import java.io.*;
import java.util.*;

class baek__11066 {
    static int[] files;
    static int[][] d;
    static int[] sum;

    static int go(int n, int m) {
        if (n > m)
            return 5000000;
        if (n == m)
            return 0;

        if (d[n][m] != -1)
            return d[n][m];

        d[n][m] = go(n, m - 1) + go(m, m) + sum[m] - (n - 1 < 0 ? 0 : sum[n - 1]);
        for (int i = n; i < m - 1; i++) {
            int temp = go(n, i) + go(i + 1, m) + sum[m] - (n - 1 < 0 ? 0 : sum[n - 1]);
            d[n][m] = Math.min(d[n][m], temp);
        }

        return d[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        String[] temp;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            files = new int[n];

            temp = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                files[i] = Integer.parseInt(temp[i]);
            }

            sum = new int[n];
            d = new int[n][n];

            sum[0] = files[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + files[i];
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = -1;
                }
            }

            sb.append(go(0, n - 1) + "\n");
        }
        System.out.print(sb);
    }
}
