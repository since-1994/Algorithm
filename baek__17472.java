// import java.io.*;
// import java.util.*;

// class Edge implements Comparable<Edge> {
// int v1;
// int v2;
// int w;

// Edge(int v1, int v2, int w) {
// this.v1 = v1;
// this.v2 = v2;
// this.w = w;
// }

// public int compareTo(Edge that) {
// Integer u = this.w;
// Integer v = that.w;

// return u.compareTo(v);
// }
// }

// class baek__17472 {

// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };

// static int find(int x, int[] parent) {
// return x == parent[x] ? parent[x] : (parent[x] = find(parent[x], parent));
// }

// static void union(int x, int y, int[] parent) {
// int r1 = find(x, parent);
// int r2 = find(y, parent);

// parent[r1] = r2;
// }

// static void dfs(int x, int y, int[][] map, int[][] color, int colour, int r,
// int c) {
// color[x][y] = colour;

// for (int k = 0; k < 4; k++) {
// int nx = x + dx[k];
// int ny = y + dy[k];

// if (nx < 0 || nx >= r || ny < 0 || ny >= c)
// continue;

// if (color[nx][ny] != 0)
// continue;

// if (map[nx][ny] != 1)
// continue;

// dfs(nx, ny, map, color, colour, r, c);
// }
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");

// int r = Integer.parseInt(temp[0]);
// int c = Integer.parseInt(temp[1]);

// int[][] map = new int[r][c];
// int[][] color = new int[r][c];

// for (int i = 0; i < r; i++) {
// temp = br.readLine().split(" ");
// for (int j = 0; j < c; j++) {
// map[i][j] = Integer.parseInt(temp[j]);
// }
// }

// int colour = 1;

// for (int i = 0; i < r; i++) {
// for (int j = 0; j < c; j++) {
// if (map[i][j] != 1)
// continue;
// if (color[i][j] != 0)
// continue;
// dfs(i, j, map, color, colour++, r, c);
// }
// }

// ArrayList<Edge> edges = new ArrayList<>();

// for (int i = 0; i < r; i++) {
// for (int j = 0; j < c; j++) {
// if (map[i][j] != 1)
// continue;

// int start = color[i][j];

// for (int k = 0; k < 4; k++) {
// int nx = i + dx[k];
// int ny = j + dy[k];
// int dist = 0;
// while (true) {
// if (nx < 0 || nx >= r || ny < 0 || ny >= c)
// break;

// if (color[nx][ny] != 0) {
// if (color[nx][ny] != start && dist >= 2) {
// edges.add(new Edge(start, color[nx][ny], dist));
// }
// break;
// }

// nx += dx[k];
// ny += dy[k];
// dist++;
// }
// }
// }
// }

// Collections.sort(edges);

// int[] parent = new int[colour];

// for (int i = 1; i < colour; i++) {
// parent[i] = i;
// }

// int answer = 0;

// for (Edge edge : edges) {
// int u = edge.v1;
// int v = edge.v2;

// int r1 = find(u, parent);
// int r2 = find(v, parent);

// if (r1 == r2)
// continue;

// parent[r1] = r2;
// answer += edge.w;
// }

// for (int i = 2; i < colour; i++) {
// if (find(i - 1, parent) != find(i, parent)) {
// System.out.print(-1);
// return;
// }
// }

// System.out.print(answer);
// }
// }
