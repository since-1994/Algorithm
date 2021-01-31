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

// class Pair {
// boolean possible;
// int ans;

// Pair(boolean possible, int ans) {
// this.possible = possible;
// this.ans = ans;
// }
// }

// class baek__17142 {
// static int ans;
// static int n, m;
// static int[][] map;
// static ArrayList<Node> deactive;
// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };

// static Pair bfs(Node[] starts) {
// int[][] dist = new int[n][n];
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// dist[i][j] = -1;
// }
// }

// Queue<Node> q = new LinkedList<>();
// for (Node start : starts) {
// q.add(start);
// dist[start.x][start.y] = 0;
// }

// while (!q.isEmpty()) {
// Node cur = q.poll();
// int x = cur.x;
// int y = cur.y;

// for (int k = 0; k < 4; k++) {
// int nx = x + dx[k];
// int ny = y + dy[k];
// if (nx < 0 || nx >= n || ny < 0 || ny >= n)
// continue;
// if (map[nx][ny] == 1)
// continue;
// if (dist[nx][ny] != -1)
// continue;
// dist[nx][ny] = dist[x][y] + 1;
// q.add(new Node(nx, ny));
// }
// }

// int returnValue = 0;

// // for (int i = 0; i < n; i++) {
// // for (int j = 0; j < n; j++) {
// // System.out.print(dist[i][j] + " ");
// // }
// // System.out.println();
// // }
// // System.out.println();

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// if (map[i][j] == 1)
// continue;
// if (dist[i][j] == -1)
// return new Pair(false, -1);
// if (map[i][j] == 0)
// returnValue = Math.max(returnValue, dist[i][j]);
// }
// }

// return new Pair(true, returnValue);
// }

// static void go(Node[] active, int now, int idx) {
// if (idx == active.length) {
// Pair pair = bfs(active);
// if (pair.possible) {
// ans = ans == -1 ? pair.ans : Math.min(ans, pair.ans);
// }
// return;
// }
// if (now >= deactive.size())
// return;

// go(active, now + 1, idx);
// active[idx] = deactive.get(now);
// go(active, now + 1, idx + 1);
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");

// n = Integer.parseInt(temp[0]);
// m = Integer.parseInt(temp[1]);
// ans = -1;
// map = new int[n][n];
// deactive = new ArrayList<>();

// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// for (int j = 0; j < n; j++) {
// map[i][j] = Integer.parseInt(temp[j]);// 2 바이러스
// if (map[i][j] == 2) {
// deactive.add(new Node(i, j));
// }
// }
// }

// Node[] active = new Node[m];
// go(active, 0, 0);

// System.out.print(ans);
// }
// }