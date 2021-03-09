import java.io.*;
import java.util.*;

class baek__20500 {
    static long[][][] d = new long[1516][3][2];
    static long r = 1000000007;

    static long go(int n, int m, int l) {// n자리의 합을 3으로 나눈 값이 m이 되는 l로 끝나는 숫자의 개수(0 => 1, 1 => 5)
        if (n == 1) {
            if (m == 1 && l == 0)
                return 1;
            else if (m == 2 && l == 1)
                return 1;
            return 0;
        }

        if (d[n][m][l] != -1)
            return d[n][m][l];

        d[n][m][l] = 0;
        for (int i = 0; i < 2; i++) {
            d[n][m][l] += go(n - 1, (m - (l == 0 ? 1 : 5) + 6) % 3, i);
            d[n][m][l] %= r;
        }

        return d[n][m][l];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 1515; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    d[i][j][k] = -1;
                }
            }
        }

        System.out.print(go(n, 0, 1));
    }
}
