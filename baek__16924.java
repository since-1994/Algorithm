// import java.io.*;
// import java.util.*;

// class Cross {
// int x;
// int y;
// int size;

// Cross(int x, int y, int size) {
// this.x = x;
// this.y = y;
// this.size = size;
// }
// }

// class baek__16924 {

// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// ArrayList<Cross> ans = new ArrayList<>();

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);
// boolean[][] check = new boolean[n][m];

// String[] map = new String[n];

// for (int i = 0; i < n; i++) {
// map[i] = br.readLine();
// }

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (map[i].charAt(j) == '*') {
// int size = 1;
// while (true) {
// boolean isRight = true;
// for (int k = 0; k < 4; k++) {
// int x = i + size * dx[k];
// int y = j + size * dy[k];
// if (x < 0 || x >= n || y < 0 || y >= m) {
// isRight = false;
// break;
// }
// if (map[x].charAt(y) != '*') {
// isRight = false;
// break;
// }
// }
// if (isRight) {
// check[i][j] = true;
// for (int k = 0; k < 4; k++) {
// int x = i + size * dx[k];
// int y = j + size * dy[k];
// check[x][y] = true;
// }
// size++;
// } else {
// if (size - 1 > 0) {
// ans.add(new Cross(i, j, size - 1));
// }
// break;
// }
// }
// }
// }
// }

// boolean haveAnswer = true;

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (map[i].charAt(j) == '*' && !check[i][j]) {
// haveAnswer = false;
// break;
// }
// }
// }
// if (haveAnswer) {
// System.out.println(ans.size());
// for (Cross cross : ans) {
// System.out.println((cross.x + 1) + " " + (cross.y + 1) + " " + cross.size);
// }
// } else {
// System.out.print(-1);
// }
// }
// }