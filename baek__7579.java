// import java.io.*;
// import java.util.*;

// class Pair {
// int m;
// int c;

// Pair(int m, int c) {
// this.m = m;
// this.c = c;
// }
// }

// class baek__7579 {
// static Pair[] pairs = new Pair[101];
// static int[][] d = new int[100 * 100 + 1][101];

// static int go(int c, int n) {
// if (c <= 0) {
// if (c == 0)
// return 0;
// return -20000000;
// }
// if (n < 0)
// return 0;

// if (d[c][n] != -1)
// return d[c][n];

// d[c][n] = Math.max(go(c - pairs[n].c, n - 1) + pairs[n].m, go(c, n - 1));

// return d[c][n];
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// temp = br.readLine().split(" ");
// String[] temp1 = br.readLine().split(" ");

// for (int i = 0; i < n; i++) {
// int memory = Integer.parseInt(temp[i]);
// int cost = Integer.parseInt(temp1[i]);
// pairs[i] = new Pair(memory, cost);
// }

// for (int i = 0; i < 100 * 100 + 1; i++) {
// for (int j = 0; j < 101; j++) {
// d[i][j] = -1;
// }
// }

// for (int i = 0; i < 100 * 100 + 1; i++) {
// if (go(i, n - 1) >= m) {
// System.out.print(i);
// return;
// }
// }
// }
// }
