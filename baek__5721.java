import java.io.*;
import java.util.*;

class baek__5721 {
    static int[][] map;
    static int[][] d;
    static int[][] d2;

    static int go(int n, int m) {// 열에서 큰거
        if (m < 0)
            return 0;

        if (d[n][m] != -1)
            return d[n][m];

        d[n][m] = Math.max(go(n, m - 2) + map[n][m], go(n, m - 1));

        return d[n][m];
    }

    static int go2(int n, int m) {
        if (n < 0)
            return 0;

        if (d2[n][m] != -1)
            return d2[n][m];

        d2[n][m] = Math.max(go2(n - 2, m) + go(n, m), go2(n - 1, m));

        return d2[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] temp = br.readLine().split(" ");
            int r = Integer.parseInt(temp[0]);
            int c = Integer.parseInt(temp[1]);
            if (r == 0 && c == 0)
                break;

            map = new int[r][c];
            d = new int[r][c];
            d2 = new int[r][c];

            for (int i = 0; i < r; i++) {
                temp = br.readLine().split(" ");
                for (int j = 0; j < c; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                    d[i][j] = -1;
                    d2[i][j] = -1;
                }
            }

            sb.append(go2(r - 1, c - 1) + "\n");
        }
        System.out.print(sb);
    }
}
