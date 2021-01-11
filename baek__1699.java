import java.io.*;
import java.util.*;

class baek__1699 {

    static int MAX = 100000;
    static int[] d = new int[MAX + 1];

    static int go(int n) {
        if (n == 0)
            return 0;
        if (d[n] != -1)
            return d[n];

        d[n] = n;

        for (int i = 1; i * i <= n; i++) {
            if (d[n] > go(n - i * i) + 1) {
                d[n] = go(n - i * i) + 1;
            }
        }

        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Arrays.fill(d, -1);

        System.out.print(go(n));

    }
}