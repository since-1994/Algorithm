// import java.io.*;
// import java.util.*;

// class Set {
// boolean canmove = false;
// boolean ishole = false;
// int x;
// int y;

// Set(boolean canmove, boolean ishole, int x, int y) {
// this.canmove = canmove;
// this.ishole = ishole;
// this.x = x;
// this.y = y;
// }

// }

// class Ans {
// boolean possible;
// int cnt;

// Ans(boolean possible, int cnt) {
// this.possible = possible;
// this.cnt = cnt;
// }
// }

// class baek__13460 {
// static int MAX = 10;

// static int n;
// static int m;

// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };

// static int[] make_dir(int num) {
// int[] dir = new int[10];
// for (int i = 0; i < 10; i++) {
// dir[i] = num & 3;
// num >>= 2;
// }
// return dir;
// }

// static boolean check_dir(int[] dir) {
// for (int i = 1; i < 10; i++) {
// if (dir[i] == dir[i - 1] || Math.abs(dir[i] - dir[i - 1]) == 2) {
// return false;
// }
// }
// return true;
// }

// static Ans go(int[] dirs, char[][] map) {
// int rx = 0;
// int ry = 0;
// int bx = 0;
// int by = 0;
// boolean rIsMoved = false;
// boolean bIsMoved = false;
// boolean rInHole = false;
// boolean bInHole = false;

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// if (map[i][j] == 'R') {
// rx = i;
// ry = j;
// }
// if (map[i][j] == 'B') {
// bx = i;
// by = j;
// }
// }
// }

// for (int k = 0; k < dirs.length; k++) {
// while (true) {
// Set r = simulation(map, rx, ry, dirs[k]);
// Set b = simulation(map, bx, by, dirs[k]);

// rx = r.x;
// ry = r.y;
// rIsMoved = r.canmove;
// rInHole = r.ishole;

// bx = b.x;
// by = b.y;
// bIsMoved = b.canmove;
// bInHole = b.ishole;

// if (!rIsMoved && !bIsMoved)
// break;
// }
// if (bInHole)
// return new Ans(false, -1);
// if (rInHole)
// return new Ans(true, k + 1);
// }

// return new Ans(false, -1);
// }

// static Set simulation(char[][] map, int x, int y, int dir) {
// if (map[x][y] == 'O') {
// return new Set(false, true, x, y);
// }

// int nx = x + dx[dir];
// int ny = y + dy[dir];
// char team = map[x][y];

// if (map[nx][ny] == (team == 'R' ? 'B' : 'R') || map[nx][ny] == '#') {
// return new Set(false, false, x, y);
// } else if (map[nx][ny] == '.') {
// map[nx][ny] = team;
// map[x][y] = '.';
// return new Set(true, false, nx, ny);
// } else {
// map[x][y] = '.';
// return new Set(true, true, nx, ny);
// }

// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// String[] temp = br.readLine().split(" ");
// n = Integer.parseInt(temp[0]);
// m = Integer.parseInt(temp[1]);

// String[] map = new String[n];
// for (int i = 0; i < n; i++) {
// map[i] = br.readLine();
// }

// int ans = -1;
// char[][] a = new char[n][m];

// for (int i = 0; i < (1 << (MAX * 2)); i++) {
// for (int j = 0; j < n; j++) {
// a[j] = map[j].toCharArray();
// }
// int[] dirs = make_dir(i);
// if (!check_dir(dirs))
// continue;
// Ans result = go(dirs, a);
// if (result.possible) {
// if (ans == -1 || ans > result.cnt) {
// ans = result.cnt;
// }
// }
// }

// System.out.print(ans);
// }
// }