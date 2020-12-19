// import java.io.*;
// import java.util.*;

// class Pair implements Comparable<Pair> {
// int x;
// int y;
// int distance;

// Pair(int x, int y, int distance) {
// this.x = x;
// this.y = y;
// this.distance = distance;
// }

// public int compareTo(Pair that) {
// if (this.distance < that.distance) {
// return -1;
// } else if (this.distance == that.distance) {
// if (this.x < that.x) {
// return -1;
// } else if (this.x == that.x) {
// if (this.y < that.y) {
// return -1;
// } else if (this.y == that.y) {
// return 0;
// } else {
// return 1;
// }
// } else {
// return 1;
// }
// } else {
// return 1;
// }
// }
// }

// class baek__16236 {

// static int[] dx = { -1, 0, 1, 0 };
// static int[] dy = { 0, -1, 0, 1 };
// static int n;
// static int[][] map;

// static Pair bfs(int baby_x, int baby_y, int size) {

// int[][] dist = new int[n][n];
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// dist[i][j] = -1;
// }
// }

// ArrayList<Pair> eatable = new ArrayList<>();
// Queue<Integer> q = new LinkedList<>();
// q.add(baby_x);
// q.add(baby_y);
// dist[baby_x][baby_y] = 0;

// while (!q.isEmpty()) {
// int x = q.poll();
// int y = q.poll();

// for (int k = 0; k < 4; k++) {
// int nx = x + dx[k];
// int ny = y + dy[k];

// if (nx < 0 || nx >= n || ny < 0 || ny >= n)
// continue;
// if (dist[nx][ny] != -1)
// continue;
// if (map[nx][ny] > size)
// continue;

// if (map[nx][ny] == size || map[nx][ny] == 0) {
// dist[nx][ny] = dist[x][y] + 1;
// q.add(nx);
// q.add(ny);
// } else {
// dist[nx][ny] = dist[x][y] + 1;
// eatable.add(new Pair(nx, ny, dist[nx][ny]));
// q.add(nx);
// q.add(ny);
// }
// }
// }

// if (eatable.size() == 0) {
// return new Pair(-1, -1, -1);
// }

// Collections.sort(eatable);
// Pair fish = eatable.get(0);
// return fish;

// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// n = Integer.parseInt(br.readLine());
// String[] temp;

// map = new int[n][n];

// int baby_x = -1;
// int baby_y = -1;

// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// for (int j = 0; j < n; j++) {
// map[i][j] = Integer.parseInt(temp[j]);
// if (map[i][j] == 9) {
// baby_x = i;
// baby_y = j;
// map[i][j] = 0;
// }
// }
// }

// int size = 2;
// int exp = 0;
// int count = 0;

// while (true) {
// Pair eat = bfs(baby_x, baby_y, size);

// if (eat.distance == -1) {
// break;
// }
// count += eat.distance;
// baby_x = eat.x;
// baby_y = eat.y;
// map[baby_x][baby_y] = 0;
// exp++;
// if (exp == size) {
// size += 1;
// exp = 0;
// }
// }

// System.out.print(count);
// }
// }