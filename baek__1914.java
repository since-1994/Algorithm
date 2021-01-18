import java.io.*;
import java.util.*;

class baek__1914 {
    static StringBuilder sb = new StringBuilder();

    static void solve(int n, int x, int y) {
        if (n == 1) {
            sb.append(x + " " + y + "\n");
            return;
        }

        solve(n - 1, x, 6 - x - y);
        sb.append(x + " " + y + "\n");
        solve(n - 1, 6 - x - y, y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long a = 1;
        long b = 0;
        long remain = (long) Math.pow(10, 15);
        for (int i = 1; i <= n; i++) {
            a *= 2;
            b *= 2;
            b += a / remain;
            a = a % remain;
        }
        if (b == 0) {
            System.out.println(a - 1);
        } else {
            System.out.println(b + "" + (a - 1));
        }
        if (n > 20)
            return;
        solve(n, 1, 3);
        System.out.print(sb);

    }
}