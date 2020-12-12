import java.io.*;
import java.util.*;

class baek__1074 {

    static int[][] order;
    static int answer;
    static int r;
    static int c;

    static void solve(int x, int y, int n) {

        if (n == 1) {
            return;
        }

        int m = n / 2;

        if (r >= x && r < x + m && c >= y && c < y + m) {
            solve(x, y, m);
            return;
        } else {
            answer += (m * m);
        }
        y += (n / 2);
        if (r >= x && r < x + m && c >= y && c < y + m) {
            solve(x, y, m);
            return;
        } else {
            answer += (m * m);
        }
        y -= (n / 2);
        x += (n / 2);
        if (r >= x && r < x + m && c >= y && c < y + m) {
            solve(x, y, m);
            return;
        } else {
            answer += (m * m);
        }
        y += (n / 2);
        if (r >= x && r < x + m && c >= y && c < y + m) {
            solve(x, y, m);
            return;
        } else {
            answer += (m * m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int m = Integer.parseInt(temp[0]);
        int n = (int) Math.pow(2, m);

        r = Integer.parseInt(temp[1]);
        c = Integer.parseInt(temp[2]);

        solve(0, 0, n);

        System.out.print(answer);
    }
}

// import java.util.*;
// import java.io.*;

// public class Main {
// static int N, r, c, answer;

// public static void main(String[] args) throws Exception {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
// N = Integer.parseInt(st.nextToken());
// r = Integer.parseInt(st.nextToken());
// c = Integer.parseInt(st.nextToken());
// int offset = 1 << N;
// getResult(offset, 0, 0);
// }

// static void getResult(int size, int y, int x) {
// if (size == 2) {
// if (isRange(y, x, size)) {
// if (checkValue(y, x))
// answer += 0;
// if (checkValue(y, x + 1))
// answer += 1;
// if (checkValue(y + 1, x))
// answer += 2;
// if (checkValue(y + 1, x + 1))
// answer += 3;
// System.out.println(answer);
// System.exit(0);
// } else
// answer += size * size;
// return;
// }

// int half = size >> 1;
// getResult(half, y, x);
// getResult(half, y, x + half);
// getResult(half, y + half, x);
// getResult(half, y + half, x + half);
// }

// static boolean checkValue(int y, int x) {
// return r == y && c == x;
// }

// static boolean isRange(int y, int x, int size) {
// return r < y + size && r >= y && c < x + size && c >= x;
// }
// }