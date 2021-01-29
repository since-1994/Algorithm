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

// class baek__9376 {
// static int r;
// static int c;

// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };

// static int[][] bfs(Point start, String[] map) {
// int[][] dist = new int[r][c];

// for (int i = 0; i < r; i++) {
// for (int j = 0; j < c; j++) {
// dist[i][j] = -1;
// }
// }

// ArrayDeque<Point> q = new ArrayDeque<>();
// q.add(start);
// dist[start.x][start.y] = 0;

// while (!q.isEmpty()) {
// Point cur = q.poll();
// int x = cur.x;
// int y = cur.y;

// for (int k = 0; k < 4; k++) {
// int nx = x + dx[k];
// int ny = y + dy[k];

// if (nx < 0 || nx >= r || ny < 0 || ny >= c)
// continue;
// if (dist[nx][ny] != -1)
// continue;
// if (map[nx].charAt(ny) == '*')
// continue;
// if (map[nx].charAt(ny) == '#') {
// dist[nx][ny] = dist[x][y] + 1;
// q.add(new Point(nx, ny));
// } else {
// dist[nx][ny] = dist[x][y];
// q.addFirst(new Point(nx, ny));
// }
// }
// }

// return dist;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringBuilder sb = new StringBuilder();
// int t = Integer.parseInt(br.readLine());

// while (t-- > 0) {
// String[] temp = br.readLine().split(" ");
// r = Integer.parseInt(temp[0]);
// c = Integer.parseInt(temp[1]);

// r += 2;
// c += 2;
// String[] map = new String[r];

// String str = "";
// for (int i = 0; i < c; i++) {
// str += '.';
// }
// map[0] = str;
// map[r - 1] = str;

// for (int i = 1; i < r - 1; i++) {
// map[i] = '.' + br.readLine() + '.';
// }

// Point p1 = new Point(0, 0);
// Point p2 = new Point(0, 0);
// Point p3 = new Point(0, 0);

// for (int i = 0; i < r; i++) {
// for (int j = 0; j < c; j++) {
// if (map[i].charAt(j) == '$') {
// if (p2.x == 0)
// p2 = new Point(i, j);
// else
// p3 = new Point(i, j);
// }
// }
// }

// int[][] dist1 = bfs(p1, map);
// int[][] dist2 = bfs(p2, map);
// int[][] dist3 = bfs(p3, map);

// int ans = dist1[0][0] + dist2[0][0] + dist3[0][0];

// for (int i = 0; i < r; i++) {
// for (int j = 0; j < c; j++) {
// if (dist1[i][j] == -1 || dist2[i][j] == -1 || dist3[i][j] == -1)
// continue;
// int cur = dist1[i][j] + dist2[i][j] + dist3[i][j];
// if (map[i].charAt(j) == '#')
// cur -= 2;
// if (cur < ans)
// ans = cur;
// }
// }

// sb.append(ans + "\n");
// }
// System.out.print(sb);
// }
// }