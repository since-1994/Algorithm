import java.io.*;
import java.util.*;

class baek__1654 {

    static int k;
    static int[] seons;

    static long calc(long mid) {
        long cnt = 0;
        for (int i = 0; i < k; i++) {
            cnt += seons[i] / mid;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        k = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);

        long l = 1;
        long r = -1;
        seons = new int[k];
        for (int i = 0; i < k; i++) {
            seons[i] = Integer.parseInt(br.readLine());
            r = r == -1 ? seons[i] : Math.max(seons[i], r);
        }
        long ans = -1;
        while (l <= r) {
            long mid = (l + r) / 2;
            long now = calc(mid);
            if (now > n) {
                l = mid + 1;
                ans = ans == -1 ? mid : Math.max(ans, mid);
            } else if (now == n) {
                l = mid + 1;
                ans = ans == -1 ? mid : Math.max(ans, mid);
            } else if (now < n) {
                r = mid - 1;
            }
        }

        System.out.print(ans);
    }
}