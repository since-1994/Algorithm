// import java.io.*;
// import java.util.*;

// class Node {
// int x;
// int y;
// int t;

// Node(int x, int y, int t) {
// this.x = x;
// this.y = y;
// this.t = t;
// }
// }

// class baek__16954 {

// static int[] dx = { -1, 0, 1, 0, -1, -1, 1, 1, 0 };
// static int[] dy = { 0, -1, 0, 1, -1, 1, -1, 1, 0 };

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// char[][] map = new char[8][8];
// boolean[][][] check = new boolean[8][8][9];

// for (int i = 0; i < 8; i++) {
// char[] row = br.readLine().toCharArray();
// for (int j = 0; j < 8; j++) {
// map[i][j] = row[j];
// }
// }

// Queue<Node> q = new LinkedList<>();
// q.add(new Node(7, 0, 0));
// check[7][0][0] = true;

// while (!q.isEmpty()) {
// Node cur = q.poll();
// int x = cur.x;
// int y = cur.y;
// int t = cur.t;

// for (int k = 0; k < 9; k++) {
// int nx = x + dx[k];
// int ny = y + dy[k];
// int nt = Math.min(8, t + 1);
// if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
// if (nx - t >= 0 && map[nx - t][ny] == '#')
// continue;
// if (nx - nt >= 0 && map[nx - nt][ny] == '#')
// continue;

// if (check[nx][ny][nt] == true)
// continue;

// if (nx == 0 && ny == 7) {
// System.out.print(1);
// return;
// }

// q.add(new Node(nx, ny, nt));
// check[nx][ny][nt] = true;
// }
// }
// }

// System.out.print(0);
// }
// }