import java.io.*;
import java.util.*;

class baek__2156 {

    static int[][] d;
    static int[] juice;

    static int go(int n, int method) {
        if (n == 0) {
            if (method == 1)
                return juice[0];
            else
                return 0;
        }
        if (d[n][method] != -1)
            return d[n][method];

        if (method == 0) {
            d[n][method] = go(n - 1, 0);
            for (int i = 1; i < 3; i++) {
                d[n][method] = Math.max(d[n][method], go(n - 1, i));
            }
        } else {
            d[n][method] = go(n - 1, method - 1) + juice[n];
        }

        return d[n][method];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        juice = new int[n];
        d = new int[n][3];

        for (int i = 0; i < n; i++) {
            juice[i] = Integer.parseInt(br.readLine());
            for (int j = 0; j < 3; j++) {
                d[i][j] = -1;
            }
        }
        int ans = -1;

        for (int i = 0; i < 3; i++) {
            ans = ans == -1 ? go(n - 1, i) : Math.max(ans, go(n - 1, i));
        }

        System.out.print(ans);
    }
}