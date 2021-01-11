import java.io.*;
import java.util.*;

class baek__11727 {
    static long[] d;

    static long go(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2) {
            return 3;
        }

        if (d[n] != -1)
            return d[n];

        d[n] = go(n - 1) + go(n - 2) * 2;
        d[n] %= 10007;

        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d = new long[n + 1];
        Arrays.fill(d, -1);

        System.out.print(go(n));

    }
}