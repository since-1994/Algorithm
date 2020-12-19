// import java.io.*;
// import java.util.*;

// class Node {
// int x;
// int y;

// Node(int x, int y) {
// this.x = x;
// this.y = y;
// }
// }

// class baek__14502 {

// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");

// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// int[][] map = new int[n][m];

// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// for (int j = 0; j < m; j++) {
// map[i][j] = Integer.parseInt(temp[j]);
// }
// }
// Queue<Node> q = new LinkedList<>();
// int answer = 0;

// for (int x1 = 0; x1 < n; x1++) {
// for (int y1 = 0; y1 < m; y1++) {
// if (map[x1][y1] != 0)
// continue;
// for (int x2 = 0; x2 < n; x2++) {
// for (int y2 = 0; y2 < m; y2++) {
// if (map[x2][y2] != 0)
// continue;
// for (int x3 = 0; x3 < n; x3++) {
// for (int y3 = 0; y3 < m; y3++) {
// if (map[x3][y3] != 0)
// continue;
// if (x1 == x2 && y1 == y2)
// continue;
// if (x3 == x2 && y3 == y2)
// continue;
// if (x3 == x1 && y3 == y1)
// continue;

// map[x1][y1] = 1;
// map[x2][y2] = 1;
// map[x3][y3] = 1;

// boolean[][] check = new boolean[n][m];

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (map[i][j] == 2) {
// check[i][j] = true;
// q.add(new Node(i, j));
// }
// }
// }

// while (!q.isEmpty()) {
// Node cur = q.poll();

// for (int k = 0; k < 4; k++) {
// int nx = cur.x + dx[k];
// int ny = cur.y + dy[k];

// if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0
// && !check[nx][ny]) {
// check[nx][ny] = true;
// q.add(new Node(nx, ny));
// }
// }
// }

// int safe = 0;

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (map[i][j] == 0 && check[i][j] == false) {
// safe++;
// }
// }
// }

// answer = Math.max(answer, safe);

// map[x1][y1] = 0;
// map[x2][y2] = 0;
// map[x3][y3] = 0;

// }
// }
// }
// }
// }
// }
// System.out.print(answer);

// }
// }