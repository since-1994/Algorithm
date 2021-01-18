import java.io.*;
import java.util.*;

class baek__1309 {
    static long[][] d;
    static long remain = 9901;

    static long go(int n, int method) {
        if (n == 0)
            return 1;
        if (d[n][method] != -1)
            return d[n][method];

        d[n][method] = 0;
        for (int i = 0; i < 3; i++) {
            if (method == 1 || method == 2) {
                if (method == i)
                    continue;
                d[n][method] += go(n - 1, i);
                d[n][method] %= remain;
            } else {
                d[n][method] += go(n - 1, i);
                d[n][method] %= remain;
            }
        }
        return d[n][method];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d = new long[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                d[i][j] = -1;
            }
        }
        long ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += go(n - 1, i);
            ans %= 9901;
        }

        System.out.print(ans);
    }
}

// import java.io.*;
// import java.util.*;

// class baek__1309 {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// int n = Integer.parseInt(br.readLine());
// long[] d = new long[n];
// long[] s = new long[n];

// d[0] = 2;
// d[1] = 4;
// s[0] = 2;
// s[1] = 6;

// for (int i = 2; i < n; i++) {
// d[i] = d[i - 1] + (2 * s[i - 2]);
// s[i] = s[i - 1] + d[i];
// }

// System.out.print(s[n - 1]);
// }
// }