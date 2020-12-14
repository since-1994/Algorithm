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