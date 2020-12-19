// import java.io.*;
// import java.util.*;

// class Node {
// int x;
// int y;
// int attack;

// Node(int x, int y, int attack) {
// this.x = x;
// this.y = y;
// this.attack = attack;
// }

// }

// class baek__2206 {

// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// int[][] map = new int[n][m];
// int[][][] dist = new int[n][m][2];

// for (int i = 0; i < n; i++) {
// char[] row = br.readLine().toCharArray();
// for (int j = 0; j < m; j++) {
// map[i][j] = row[j] - '0';
// for (int k = 0; k < 2; k++) {
// dist[i][j][k] = -1;
// }
// }
// }

// Queue<Node> q = new LinkedList<>();

// dist[0][0][0] = 1;
// q.add(new Node(0, 0, 0));

// while (!q.isEmpty()) {
// Node cur = q.poll();
// int x = cur.x;
// int y = cur.y;
// int attack = cur.attack;

// for (int k = 0; k < 4; k++) {
// int nx = x + dx[k];
// int ny = y + dy[k];

// if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
// if (map[nx][ny] == 0 && dist[nx][ny][attack] == -1) {
// dist[nx][ny][attack] = dist[x][y][attack] + 1;
// q.add(new Node(nx, ny, attack));
// } else if (map[nx][ny] == 1 && attack == 0 && dist[nx][ny][attack + 1] == -1)
// {
// dist[nx][ny][attack + 1] = dist[x][y][attack] + 1;
// q.add(new Node(nx, ny, attack + 1));
// }
// }
// }
// }

// int d1 = dist[n - 1][m - 1][0];
// int d2 = dist[n - 1][m - 1][1];

// if (d1 != -1 && d2 != -1) {
// System.out.print(Math.min(d1, d2));
// return;
// } else if (d1 != -1) {
// System.out.print(d1);
// return;
// } else {
// System.out.print(d2);
// return;
// }

// }
// }