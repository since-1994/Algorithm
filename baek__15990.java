import java.io.*;
import java.util.*;

class baek__15990 {
    static int MAX = 100000;
    static int remain = 1000000009;
    static long[][] d = new long[MAX + 1][4];

    static long go(int n, int lastUsed) {
        if (n < 0) {
            return 0;
        }
        if (n == lastUsed)
            return 1;
        if (d[n][lastUsed] != -1) {
            return d[n][lastUsed];
        }

        d[n][lastUsed] = 0;

        for (int i = 1; i <= 3; i++) {
            if (i == lastUsed)
                continue;
            d[n][lastUsed] += go(n - lastUsed, i);
            d[n][lastUsed] %= remain;
        }

        return d[n][lastUsed];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < MAX + 1; i++) {
            for (int j = 0; j < 4; j++) {
                d[i][j] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long temp = go(n, 1) + go(n, 2);
            temp %= remain;
            temp += go(n, 3);
            temp %= remain;
            sb.append(temp);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}