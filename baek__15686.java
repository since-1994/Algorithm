// import java.io.*;
// import java.util.*;

// class Point {
// int x;
// int y;

// Point(int x, int y) {
// this.x = x;
// this.y = y;
// }
// }

// class Main {

// static boolean isPossible(int method, int limit, int tot) {
// int cnt = 0;

// for (int i = 0; i < tot; i++) {
// if ((method & (1 << i)) > 0)
// cnt++;
// }

// if (cnt > limit)
// return false;
// return true;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);
// int[][] map = new int[n][n];

// ArrayList<Point> houses = new ArrayList<>();
// ArrayList<Point> chickens = new ArrayList<>();

// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// for (int j = 0; j < n; j++) {
// map[i][j] = Integer.parseInt(temp[j]);
// if (map[i][j] == 1) {
// houses.add(new Point(i, j));
// } else if (map[i][j] == 2) {
// chickens.add(new Point(i, j));
// }
// }
// }
// int ans = 2* n * n * n;

// for (int k = 0; k < (1 << chickens.size()); k++) {
// if (!isPossible(k, m, chickens.size()))
// continue;
// int ans_temp = 0;
// for (Point house : houses) {
// int min = n * n;
// for (int i = 0; i < chickens.size(); i++) {
// if ((k & (1 << i)) > 0) {
// Point chicken = chickens.get(i);
// min = Math.min(min, Math.abs(chicken.x - house.x) + Math.abs(chicken.y -
// house.y));
// }
// }
// ans_temp += min;
// }
// ans = Math.min(ans_temp, ans);
// }
// System.out.print(ans);
// }
// }