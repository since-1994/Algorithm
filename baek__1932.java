import java.io.*;
import java.util.*;

class baek__1932 {
    static int[][] triangle;
    static int[][] d;

    static int go(int n, int m) {
        if (m < 0 || n < m)
            return 0;
        if (n == 0) {
            if (m == 0)
                return triangle[n][m];
            return 0;
        }
        if (d[n][m] != -1)
            return d[n][m];

        d[n][m] = Math.max(go(n - 1, m - 1), go(n - 1, m));

        d[n][m] += triangle[n][m];

        return d[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        d = new int[n][n];

        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(temp[j]);
                d[i][j] = -1;
            }
        }

        int ans = -1;

        for (int i = 0; i < n; i++) {
            ans = ans == -1 ? go(n - 1, i) : Math.max(ans, go(n - 1, i));
        }

        System.out.print(ans);

    }
}