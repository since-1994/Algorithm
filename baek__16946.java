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

// class baek__16946 {

// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// int[][] map = new int[n][m];
// int[][] groupNr = new int[n][m];

// for (int i = 0; i < n; i++) {
// char[] row = br.readLine().toCharArray();
// for (int j = 0; j < m; j++) {
// map[i][j] = row[j] - '0';
// groupNr[i][j] = -1;
// }
// }

// Queue<Node> q = new LinkedList<>();
// int[] count = new int[n * m];
// int idx = 0;

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (groupNr[i][j] == -1 && map[i][j] == 0) {
// q.add(new Node(i, j));
// groupNr[i][j] = idx++;
// count[groupNr[i][j]] += 1;

// while (!q.isEmpty()) {
// Node cur = q.poll();
// int x = cur.x;
// int y = cur.y;

// for (int k = 0; k < 4; k++) {
// int nx = x + dx[k];
// int ny = y + dy[k];
// if (nx >= 0 && nx < n && ny >= 0 && ny < m && groupNr[nx][ny] == -1 &&
// map[nx][ny] == 0) {
// groupNr[nx][ny] = groupNr[x][y];
// count[groupNr[nx][ny]] += 1;
// q.add(new Node(nx, ny));
// }
// }
// }
// }
// }
// }

// // for (int i = 0; i < n; i++) {
// // for (int j = 0; j < m; j++) {
// // System.out.print(groupNr[i][j]);
// // }
// // System.out.println();
// // }
// StringBuilder sb = new StringBuilder();

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (map[i][j] == 0) {
// sb.append(0);
// } else {
// HashSet<Integer> set = new HashSet<>();

// for (int k = 0; k < 4; k++) {
// int nx = i + dx[k];
// int ny = j + dy[k];

// if (nx >= 0 && nx < n && ny >= 0 && ny < m && groupNr[nx][ny] != -1) {
// set.add(groupNr[nx][ny]);
// }
// }

// int ans = 1;
// Iterator iterator = set.iterator();
// while (iterator.hasNext()) {
// ans += count[(int) iterator.next()];
// }
// sb.append(ans % 10);
// }
// }
// sb.append('\n');
// }

// System.out.print(sb);

// }
// }