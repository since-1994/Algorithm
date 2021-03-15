import java.io.*;
import java.util.*;

class baek__11049 {
    static int[][] items;
    static int[][] d = new int[501][501];

    static int go(int n, int m) {
        if (n == m)
            return 0;

        if (d[n][m] != -1)
            return d[n][m];

        d[n][m] = (1 << 31) - 1;
        for (int i = n; i < m; i++) {
            d[n][m] = Math.min(d[n][m], go(n, i) + go(i + 1, m) + items[n][0] * items[i][1] * items[m][1]);
        }

        return d[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        items = new int[n][2];

        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            items[i][0] = Integer.parseInt(temp[0]);
            items[i][1] = Integer.parseInt(temp[1]);
        }

        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                d[i][j] = -1;
            }
        }

        System.out.print(go(0, n - 1));
    }
}
