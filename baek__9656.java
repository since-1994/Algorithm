import java.io.*;
import java.util.*;

class baek__9656 {
    static int[] d = new int[1000 + 1];

    static int go(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 0) {
            return 1000;
        }

        if (d[n] != -1)
            return d[n];

        d[n] = Math.min(go(n - 1) + 1, go(n - 3) + 1);

        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Arrays.fill(d, -1);

        if (go(n) % 2 == 1)
            System.out.print("CY");
        else
            System.out.print("SK");
    }
}
