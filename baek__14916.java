import java.io.*;
import java.util.*;

class baek__14916 {
    static int[] d = new int[100000 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(d, -1);
        int n = Integer.parseInt(br.readLine());

        d[0] = 0;
        for (int i = 2; i <= n; i++) {

            if (i >= 2) {
                d[i] = Math.min(d[i], d[i - 2] + 1);
            }

            if (i >= 5) {
                d[i] = Math.min(d[i], d[i - 5] + 1);
            }

        }

        System.out.print(d[n]);

    }
}
