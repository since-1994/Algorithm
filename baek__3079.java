import java.io.*;
import java.util.*;

class baek__3079 {
    static int n;
    static int m;
    static int[] t;

    static boolean check(long time) {
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt += (time / t[i]);
        }

        if (cnt >= m) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        t = new int[n];
        int min = 1000000000;
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, t[i]);
        }

        long l = -1;
        long r = 1L * min * m;

        while (l + 1 < r) {
            long mid = (l + r) / 2;

            if (check(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.print(r);
    }
}
