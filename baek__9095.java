import java.io.*;
import java.util.*;

class baek__9095 {

    static int[] d = new int[11 + 1];

    static int go(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (d[n] != -1)
            return d[n];

        d[n] = go(n - 1) + go(n - 2) + go(n - 3);
        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Arrays.fill(d, -1);

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(go(n) + "\n");
        }

        System.out.print(sb);
    }
}