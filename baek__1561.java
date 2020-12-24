import java.io.*;
import java.util.*;

class baek__1561 {

    static long calc(long[] a, long time) {
        if (time == -1)
            return 0;

        long cnt = 0;

        for (int i = 0; i < a.length; i++) {
            cnt += (time / a[i]);
        }
        cnt += a.length;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // String[] temp = br.readLine().split(" ");
        // int n = Integer.parseInt(temp[0]);
        // int m = Integer.parseInt(temp[1]);

        // long[] a = new long[m];
        // temp = br.readLine().split(" ");

        // for (int i = 0; i < m; i++) {
        // a[i] = Long.parseLong(temp[i]);
        // }

        // long left = 0;
        // long right = 2000000000 * 30 + 1;
        // long ans = 0;

        // while (left <= right) {
        // long mid = (left + right) / 2;
        // if (calc(a, mid) >= n) {
        // ans = mid;
        // right = mid - 1;
        // } else {
        // left = mid + 1;
        // }
        // }

        // long index = n - calc(a, ans - 1);
        // for (int i = 0; i < m; i++) {
        // if (ans % a[i] == 0) {
        // index--;
        // if (index == 0) {
        // System.out.print(i + 1);
        // return;
        // }
        // }
        // }

        long another = 2000000000 * 2;
        System.out.println(another);

    }
}