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

// class baek__1981 {
// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };
// static int n;
// static int[][] map;
// static boolean[][] check = new boolean[100][100];

// static boolean bfs(Queue<Point> q, int min, int max) {
// for (int i = 0; i < 100; i++) {
// for (int j = 0; j < 100; j++) {
// check[i][j] = false;
// }
// }

// if (map[0][0] < min || map[0][0] > max) {
// return false;
// }
// q.add(new Point(0, 0));
// check[0][0] = true;

// while (!q.isEmpty()) {
// Point cur = q.poll();
// for (int k = 0; k < 4; k++) {
// int nx = cur.x + dx[k];
// int ny = cur.y + dy[k];

// if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
// if (check[nx][ny])
// continue;
// if (map[nx][ny] < min || map[nx][ny] > max)
// continue;
// q.add(new Point(nx, ny));
// check[nx][ny] = true;
// }
// }
// }

// if (check[n - 1][n - 1])
// return true;

// return false;
// }

// static boolean go(int diff) {
// Queue<Point> q = new LinkedList<>();

// for (int min = 0; min + diff <= 200; min++) {
// if (bfs(q, min, min + diff))
// return true;
// }

// return false;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// n = Integer.parseInt(br.readLine());
// map = new int[n][n];
// String[] temp;

// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// for (int j = 0; j < n; j++) {
// map[i][j] = Integer.parseInt(temp[j]);
// }
// }

// int left = 0;
// int right = 200;
// int ans = -1;

// while (left <= right) {
// int mid = (left + right) / 2;
// if (go(mid)) {
// ans = mid;
// right = mid - 1;
// } else {// 더 들어갈 수 있는 수를 늘려줘야지!!!!!
// left = mid + 1;
// }
// }

// System.out.print(ans);
// }
// }