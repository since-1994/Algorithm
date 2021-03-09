// import java.io.*;
// import java.util.*;

// class Pair {
// int x;
// int y;
// int m;

// Pair(int x, int y, int m) {
// this.x = x;
// this.y = y;
// this.m = m;
// }
// }

// class baek__9252 {
// static String s;
// static String ss;
// static int[][] d = new int[1001][1001];
// static Pair[][] before = new Pair[1001][1001];

// static int go(int i, int j) {
// if (i == 0 || j == 0)
// return 0;

// if (d[i][j] != -1) {
// return d[i][j];
// }

// if (s.charAt(i - 1) == ss.charAt(j - 1)) {
// d[i][j] = go(i - 1, j - 1) + 1;
// before[i][j] = new Pair(i - 1, j - 1, 1);
// } else {
// int a = go(i - 1, j);
// int b = go(i, j - 1);
// if (a < b) {
// d[i][j] = b;
// before[i][j] = new Pair(i, j - 1, -1);
// } else {
// d[i][j] = a;
// before[i][j] = new Pair(i - 1, j, -1);
// }
// }
// return d[i][j];
// }

// static void print(int x, int y) {
// if (d[x][y] == 1 && before[x][y].m == 1) {
// System.out.print(s.charAt(x - 1));
// return;
// }
// print(before[x][y].x, before[x][y].y);
// if (d[x][y] != 1 && before[x][y].m == 1)
// System.out.print(s.charAt(x - 1));
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// s = br.readLine();
// ss = br.readLine();

// for (int i = 0; i < s.length() + 1; i++) {
// for (int j = 0; j < ss.length() + 1; j++) {
// d[i][j] = -1;
// before[i][j] = new Pair(i, j, -1);
// }
// }
// System.out.println(go(s.length(), ss.length()));
// if (d[s.length()][ss.length()] != 0)
// print(s.length(), ss.length());
// }
// }
