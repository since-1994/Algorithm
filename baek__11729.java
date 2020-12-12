import java.io.*;
import java.util.*;

class baek__11729 {

    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    static void solve(int x, int y, int n) {
        if (n == 0) {
            return;
        }
        int z = 6 - x - y;
        solve(x, z, n - 1);
        sb.append(x + " " + y + "\n");
        cnt++;
        solve(z, y, n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        solve(1, 3, n);

        System.out.println(cnt);
        System.out.print(sb);
    }
}