import java.io.*;
import java.util.*;

class baek__1561 {
    static long MAX = 2000000000;
    static int n;
    static int m;
    static int[] rides;

    static long calc(long t) {
        if (t == -1) {
            return 0;
        }
        long cnt = 0;

        cnt += m;

        for (int i = 0; i < m; i++) {
            cnt += t / rides[i];
        }

        return cnt;
    }

    static boolean check(long t) {
        long cnt = 0;

        cnt += m;

        for (int i = 0; i < m; i++) {
            cnt += t / rides[i];
        }

        if (cnt >= n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        rides = new int[m];
        temp = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            rides[i] = Integer.parseInt(temp[i]);
        }

        long l = -1;
        long r = MAX * 30;

        while (l + 1 < r) {
            long mid = (l + r) / 2;

            if (check(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        int cnt = n - (int) calc(r - 1);

        for (int i = 0; i < m; i++) {
            if (r % rides[i] == 0) {
                cnt--;
                if (cnt == 0) {
                    System.out.print(i + 1);
                    return;
                }
            }
        }

    }
}
