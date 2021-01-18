// import java.io.*;
// import java.util.*;

// class Pair {
// long x;
// long y;

// Pair(long x, long y) {
// this.x = x;
// this.y = y;
// }
// }

// class baek__1891 {

// static String target;
// static Pair end;

// static String answer(long x, long y, long n, String ans) {
// if (n == 1)
// return ans;

// long k = n / 2;

// long nx = x;
// long ny = y;

// if (end.x >= nx && end.x < nx + k && end.y >= ny && end.y < ny + k) {
// return answer(nx, ny, k, ans + "2");
// }
// nx = x;
// ny = y + k;
// if (end.x >= nx && end.x < nx + k && end.y >= ny && end.y < ny + k) {
// return answer(nx, ny, k, ans + "1");
// }
// nx = x + k;
// ny = y + k;
// if (end.x >= nx && end.x < nx + k && end.y >= ny && end.y < ny + k) {
// return answer(nx, ny, k, ans + "4");
// }
// nx = x + k;
// ny = y;
// return answer(nx, ny, k, ans + "3");

// }

// static Pair solve(long x, long y, long n, int idx) {
// if (n == 1) {
// return new Pair(x, y);
// }

// long k = n / 2;

// long nx = x;
// long ny = y + k;

// if (target.charAt(idx) == '1') {
// return solve(nx, ny, k, idx + 1);
// }
// ny = y;
// if (target.charAt(idx) == '2') {
// return solve(nx, ny, k, idx + 1);
// }
// nx = x + k;
// if (target.charAt(idx) == '3') {
// return solve(nx, ny, k, idx + 1);
// }
// ny = y + k;
// return solve(nx, ny, k, idx + 1);
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int depth = Integer.parseInt(temp[0]);
// target = temp[1];

// temp = br.readLine().split(" ");
// long r = Long.parseLong(temp[0]);
// long c = Long.parseLong(temp[1]);

// long n = (long) 1 << depth;

// Pair start = solve(0, 0, n, 0);

// end = new Pair(start.x - c, start.y + r);

// if (end.x >= 0 && end.x < n && end.y >= 0 && end.y < n) {
// System.out.print(answer(0, 0, n, ""));
// } else {
// System.out.print(-1);
// }
// }
// }

import java.io.*;
import java.util.*;

class baek__1891 {
    static long targetX = -1;
    static long targetY = -1;
    static String ans = "";
    static int[] dx = { 0, 0, 1, 1 };
    static int[] dy = { 1, 0, 0, 1 };

    static void go(long x, long y, long len, String target, String now) {
        if (len == 1) {
            if (target.equals(now)) {
                targetX = x;
                targetY = y;
            }
            return;
        }
        long nextLen = len / 2;
        for (int k = 0; k < 4; k++) {
            if (target.charAt(now.length()) == (char) (k + 1 + '0')) {
                go(x + dx[k] * nextLen, y + dy[k] * nextLen, nextLen, target, now + Integer.toString(k + 1));
            }
        }
    }

    static void go2(long x, long y, long len, long r, long c, String now) {
        if (len == 1) {
            if (targetX - c == x && targetY + r == y) {
                ans = now;
            }
            return;
        }
        long nextLen = len / 2;
        for (int k = 0; k < 4; k++) {
            if (x + dx[k] * nextLen <= targetX - c && targetX - c <= x + dx[k] * nextLen + nextLen - 1
                    && y + dy[k] * nextLen <= targetY + r && y + dy[k] * nextLen + nextLen - 1 >= targetY + r) {
                go2(x + dx[k] * nextLen, y + dy[k] * nextLen, nextLen, r, c, now + Integer.toString(k + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int d = Integer.parseInt(temp[0]);
        String target = temp[1];

        temp = br.readLine().split(" ");
        long r = Long.parseLong(temp[0]);
        long c = Long.parseLong(temp[1]);

        go(0, 0, (long) Math.pow(2, d), target, "");
        go2(0, 0, (long) Math.pow(2, d), r, c, "");
        System.out.print(ans.equals("") ? -1 : ans);
    }
}