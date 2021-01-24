// import java.io.*;
// import java.util.*;

// class baek__1300 {

// static long n;

// static long calc(long target) {
// long cnt = 0;

// for (long i = 1; i <= n; i++) {
// cnt += Math.min(n, target / i);
// }

// return cnt;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// n = Integer.parseInt(br.readLine());
// long k = Integer.parseInt(br.readLine());

// long left = 1;
// long right = n * n;
// long ans = -1;

// while (left <= right) {
// long mid = (left + right) / 2;

// if (calc(mid) >= k) {
// ans = mid;
// right = mid - 1;
// } else {
// left = mid + 1;
// }
// }

// System.out.print(ans);
// }
// }

import java.io.*;
import java.util.*;

class baek__1300 {
    static long n;

    static long calc(long now) {
        long cnt = 0;

        for (long i = 1; i <= n; i++) {
            cnt += Math.min(n, now / i);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        long b = 10;
        long a = 100 * 100000000 * b;
        System.out.print(a);
    }
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // n = Long.parseLong(br.readLine());
    // long k = Long.parseLong(br.readLine());

    // long l = 1;
    // long r = n * n;
    // long ans = 0;

    // while (l <= r) {
    // long mid = (l + r) / 2;
    // if (calc(mid) >= k) {
    // ans = mid;
    // r = mid - 1;
    // } else {
    // l = mid + 1;
    // }
    // }

    // System.out.print(ans);
    // }
}