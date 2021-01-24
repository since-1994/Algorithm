// import java.io.*;
// import java.util.*;

// class baek__1561 {

//     static long calc(long[] a, long time) {
//         if (time == -1)
//             return 0;

//         long cnt = 0;

//         for (int i = 0; i < a.length; i++) {
//             cnt += (time / a[i]);
//         }
//         cnt += a.length;
//         return cnt;
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         // String[] temp = br.readLine().split(" ");
//         // int n = Integer.parseInt(temp[0]);
//         // int m = Integer.parseInt(temp[1]);

//         // long[] a = new long[m];
//         // temp = br.readLine().split(" ");

//         // for (int i = 0; i < m; i++) {
//         // a[i] = Long.parseLong(temp[i]);
//         // }

//         // long left = 0;
//         // long right = 2000000000 * 30 + 1;
//         // long ans = 0;

//         // while (left <= right) {
//         // long mid = (left + right) / 2;
//         // if (calc(a, mid) >= n) {
//         // ans = mid;
//         // right = mid - 1;
//         // } else {
//         // left = mid + 1;
//         // }
//         // }

//         // long index = n - calc(a, ans - 1);
//         // for (int i = 0; i < m; i++) {
//         // if (ans % a[i] == 0) {
//         // index--;
//         // if (index == 0) {
//         // System.out.print(i + 1);
//         // return;
//         // }
//         // }
//         // }

//         long another = 2000000000 * 2;
//         System.out.println(another);

//     }
// }

import java.io.*;
import java.util.*;

class baek__1561 {
    static long[] times;
    static long n;
    static int m;

    static long calc(long time) {
        long cnt = m;

        for (int i = 0; i < m; i++) {
            cnt += time / times[i];
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        n = Long.parseLong(temp[0]);
        m = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");
        times = new long[m];
        for (int i = 0; i < m; i++) {
            times[i] = Long.parseLong(temp[i]);
        }

        long l = 0;
        long r = 30 * n;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (calc(mid) >= n) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        if (ans == 0) {
            System.out.println(n);
            return;
        } else {
            long idx = n - calc(ans - 1);
            int answer = 0;
            for (int i = 0; i < m; i++) {
                if (ans % times[i] == 0) {
                    answer = i;
                    idx--;
                }
                if (idx == 0)
                    break;
            }
            System.out.print(answer + 1);
        }

    }
}