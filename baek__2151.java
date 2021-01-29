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

// class baek__2151 {

// static Point door1;
// static Point door2;
// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// char[][] map = new char[n][n];
// int[][] dist = new int[n][n];
// door1 = new Point(-1, -1);
// door2 = new Point(-1, -1);

// char[] temp;
// for (int i = 0; i < n; i++) {
// temp = br.readLine().toCharArray();
// for (int j = 0; j < n; j++) {
// dist[i][j] = -1;
// map[i][j] = temp[j];
// if (map[i][j] == '#') {
// if (door1.x == -1) {
// door1 = new Point(i, j);
// } else {
// door2 = new Point(i, j);
// }
// }
// }
// }

// ArrayDeque<Point> q = new ArrayDeque<>();
// q.add(door1);
// dist[door1.x][door1.y] = 0;

// while (!q.isEmpty()) {
// Point cur = q.poll();
// int x = cur.x;
// int y = cur.y;

// for (int k = 0; k < 4; k++) {
// int nx = x + dx[k];
// int ny = y + dy[k];
// if (nx < 0 || nx >= n || ny < 0 || ny >= n)
// continue;
// while (map[nx][ny] != '*') {
// if (dist[nx][ny] != -1) {
// nx += dx[k];
// ny += dy[k];
// if (nx < 0 || nx >= n || ny < 0 || ny >= n)
// break;
// continue;
// }
// if (map[x][y] == '!') {
// dist[nx][ny] = dist[x][y] + 1;
// } else {
// dist[nx][ny] = dist[x][y];
// }
// if (map[nx][ny] == '!') {
// q.add(new Point(nx, ny));
// }
// nx += dx[k];
// ny += dy[k];
// if (nx < 0 || nx >= n || ny < 0 || ny >= n)
// break;
// }
// }

// }
// System.out.print(dist[door2.x][door2.y]);
// }
// }