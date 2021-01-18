import java.io.*;
import java.util.*;

class baek__2133 {
    static int[] d;

    static int go(int n) {
        if (n < 0)
            return 0;
        if (n == 0) {
            return 1;
        }
        if (d[n] != -1)
            return d[n];

        d[n] = 0;
        d[n] += go(n - 2) * 3;
        for (int i = 4; i <= n; i += 2) {
            d[n] += go(n - i) * 2;
        }

        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        Arrays.fill(d, -1);
        System.out.print(go(n));
    }
}