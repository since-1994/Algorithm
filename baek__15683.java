// import java.io.*;
// import java.util.*;

// class CCTV {
// int x;
// int y;
// int type;

// CCTV(int x, int y, int type) {
// this.x = x;
// this.y = y;
// this.type = type;
// }
// }

// class baek__15683 {

// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };

// static int[] make_dir(int k, int n) {

// int[] dirs = new int[n];

// for (int idx = 0; idx < n; idx++) {
// dirs[idx] = (k & 3);
// k >>= 2;
// }

// return dirs;
// }

// static void check(int[][] map, int x, int y, int dir, int n, int m) {
// while (true) {
// int nx = x + dx[dir];
// int ny = y + dy[dir];
// if (nx < 0 || nx >= n || ny < 0 || ny >= m)
// break;
// if (map[nx][ny] == 6)
// break;
// x = nx;
// y = ny;
// if (1 <= map[nx][ny] && map[nx][ny] <= 5)
// continue;
// map[nx][ny] = -1;
// }
// }

// static int go(int[][] map, ArrayList<CCTV> cctvs, int[] dirs, int n, int m) {
// int[][] temp = new int[n][m];
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// temp[i][j] = map[i][j];
// }
// }

// for (int i = 0; i < dirs.length; i++) {
// int x = cctvs.get(i).x;
// int y = cctvs.get(i).y;

// if (cctvs.get(i).type == 1) {
// check(temp, x, y, dirs[i], n, m);
// } else if (cctvs.get(i).type == 2) {
// check(temp, x, y, dirs[i], n, m);
// check(temp, x, y, (dirs[i] + 2) % 4, n, m);
// } else if (cctvs.get(i).type == 3) {
// check(temp, x, y, dirs[i], n, m);
// check(temp, x, y, (dirs[i] + 1) % 4, n, m);
// } else if (cctvs.get(i).type == 4) {
// check(temp, x, y, dirs[i], n, m);
// check(temp, x, y, (dirs[i] + 1) % 4, n, m);
// check(temp, x, y, (dirs[i] + 2) % 4, n, m);
// } else if (cctvs.get(i).type == 5) {
// check(temp, x, y, dirs[i], n, m);
// check(temp, x, y, (dirs[i] + 1) % 4, n, m);
// check(temp, x, y, (dirs[i] + 2) % 4, n, m);
// check(temp, x, y, (dirs[i] + 3) % 4, n, m);
// }
// }
// int cnt = 0;
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (temp[i][j] == 0)
// cnt++;
// }
// }

// return cnt;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// int[][] map = new int[n][m];
// ArrayList<CCTV> cctvs = new ArrayList<>();

// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// for (int j = 0; j < m; j++) {
// map[i][j] = Integer.parseInt(temp[j]);
// if (1 <= map[i][j] && map[i][j] <= 5) {
// cctvs.add(new CCTV(i, j, map[i][j]));
// }
// }
// }

// int ans = n * m;

// for (int k = 0; k < (1 << cctvs.size() * 2); k++) {
// int[] dirs = make_dir(k, cctvs.size());
// ans = Math.min(ans, go(map, cctvs, dirs, n, m));
// }

// System.out.print(ans);

// }
// }