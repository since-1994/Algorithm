// import java.io.*;
// import java.util.*;

// class Point {
// int value;
// boolean merged;

// Point(int value, boolean merged) {
// this.value = value;
// this.merged = merged;
// }
// }

// class baek__12100 {

// static int MAX = 5;
// static int n;
// static int[] dx = { -1, 0, 1, 0 };// 위 왼 아래 우
// static int[] dy = { 0, -1, 0, 1 };

// static int[] make_dir(int k) {
// int[] dirs = new int[MAX];

// for (int i = 0; i < MAX; i++) {
// dirs[i] = (k & 3);
// k >>= 2;
// }

// return dirs;
// }

// static int go(Point[][] map, int[] dirs) {

// for (int dir : dirs) {
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// map[i][j].merged = false;
// }
// }
// boolean moved = false;
// while (true) {
// moved = false;

// if (dir == 0) {
// for (int i = n - 2; i >= 0; i--) {
// for (int j = 0; j < n; j++) {
// if (map[i][j].value == 0)
// continue;
// else if (map[i + 1][j].value == 0) {
// moved = true;
// map[i + 1][j].value = map[i][j].value;
// map[i + 1][j].merged = map[i][j].merged;
// map[i][j] = new Point(0, false);
// } else if (map[i + 1][j].value == map[i][j].value && !map[i][j].merged
// && !map[i + 1][j].merged) {
// moved = true;
// map[i + 1][j].value *= 2;
// map[i][j].value = 0;
// map[i + 1][j].merged = true;
// }
// }
// }
// } else if (dir == 1) {
// for (int j = 1; j < n; j++) {
// for (int i = 0; i < n; i++) {
// if (map[i][j].value == 0)
// continue;
// else if (map[i][j - 1].value == 0) {
// moved = true;
// map[i][j - 1].value = map[i][j].value;
// map[i][j - 1].merged = map[i][j].merged;
// map[i][j] = new Point(0, false);
// } else if (map[i][j - 1].value == map[i][j].value && !map[i][j].merged
// && !map[i][j - 1].merged) {
// moved = true;
// map[i][j - 1].value *= 2;
// map[i][j].value = 0;
// map[i][j - 1].merged = true;
// }
// }
// }
// } else if (dir == 2) {
// for (int i = 1; i < n; i++) {
// for (int j = 0; j < n; j++) {
// if (map[i][j].value == 0)
// continue;
// else if (map[i - 1][j].value == 0) {
// moved = true;
// map[i - 1][j].value = map[i][j].value;
// map[i - 1][j].merged = map[i][j].merged;
// map[i][j] = new Point(0, false);
// } else if (map[i - 1][j].value == map[i][j].value && !map[i][j].merged
// && !map[i - 1][j].merged) {
// moved = true;
// map[i - 1][j].value *= 2;
// map[i][j].value = 0;
// map[i - 1][j].merged = true;
// }
// }
// }

// } else {
// for (int j = n - 2; j >= 0; j--) {
// for (int i = 0; i < n; i++) {
// if (map[i][j].value == 0)
// continue;
// else if (map[i][j + 1].value == 0) {
// moved = true;
// map[i][j + 1].value = map[i][j].value;
// map[i][j + 1].merged = map[i][j].merged;
// map[i][j] = new Point(0, false);
// } else if (map[i][j + 1].value == map[i][j].value && !map[i][j].merged
// && !map[i][j + 1].merged) {
// moved = true;
// map[i][j + 1].value *= 2;
// map[i][j].value = 0;
// map[i][j + 1].merged = true;
// }
// }
// }
// }
// if (moved == false)
// break;
// }

// }

// int returnValue = 0;

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// returnValue = Math.max(returnValue, map[i][j].value);
// }
// }

// return returnValue;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// n = Integer.parseInt(br.readLine());
// String[] temp;

// int[][] map = new int[n][n];
// Point[][] a = new Point[n][n];

// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// for (int j = 0; j < n; j++) {
// map[i][j] = Integer.parseInt(temp[j]);
// }
// }

// int ans = -1;

// for (int k = 0; k < (1 << (MAX * 2)); k++) {
// int[] dirs = make_dir(k);
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// a[i][j] = new Point(map[i][j], false);
// }
// }
// int result = go(a, dirs);
// if (ans == -1 || result > ans) {
// ans = result;
// }
// }

// System.out.print(ans);
// }
// }
