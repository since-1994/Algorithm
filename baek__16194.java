import java.io.*;
import java.util.*;

class baek__16194 {

    static int[] p;
    static int[] d;

    static int go(int n) {
        if (n == 0)
            return 0;
        if (d[n] != -1)
            return d[n];

        d[n] = 10000 * n;
        for (int i = 1; i <= n; i++) {
            d[n] = Math.min(d[n], go(n - i) + p[i]);
        }

        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        Arrays.fill(d, -1);

        String[] temp = br.readLine().split(" ");
        p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = Integer.parseInt(temp[i]);
        }

        System.out.print(go(n));

    }
}