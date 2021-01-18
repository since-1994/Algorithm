import java.io.*;
import java.util.*;

class baek__1149 {
    static int[][] price = new int[1000][3];
    static int[][] d = new int[1000][3];

    static int go(int n, int color) {
        if (n == 0) {
            return price[n][color];
        }
        if (d[n][color] != -1)
            return d[n][color];

        int ans = -1;
        for (int i = 0; i < 3; i++) {
            if (i == color)
                continue;
            ans = ans == -1 ? go(n - 1, i) : Math.min(go(n - 1, i), ans);
        }

        d[n][color] = ans + price[n][color];

        return d[n][color];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                price[i][j] = Integer.parseInt(temp[j]);
                d[i][j] = -1;
            }
        }

        int ans = go(n - 1, 0);
        for (int i = 1; i < 3; i++) {
            ans = Math.min(go(n - 1, i), ans);
        }

        System.out.print(ans);
    }
}