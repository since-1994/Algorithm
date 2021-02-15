// import java.io.*;
// import java.util.*;

// class Pair {
// int x;
// long v;

// Pair(int x, long v) {
// this.x = x;
// this.v = v;
// }
// }

// class baek__1728 {
// static int n;
// static int[][] marbles;

// static boolean find(long target, int i) {
// int l = -1;
// int r = n;

// while (l + 1 < r) {
// int mid = (l + r) / 2;
// if (marbles[i][mid] < target) {
// l = mid;
// } else {
// r = mid;
// }
// }

// if (r == -1)
// return false;
// if (marbles[i][r] == target) {
// return true;
// }
// return false;
// }

// static boolean check(int start, long v) {
// long next = start + v;

// for (int i = 1; i < n + 1; i++) {
// if (find(next, i)) {
// next += v;
// } else {
// return false;
// }
// }
// return true;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// n = Integer.parseInt(br.readLine());
// marbles = new int[n + 1][n];

// String[] temp;
// int[] arr = new int[n];
// for (int i = 0; i < n + 1; i++) {
// temp = br.readLine().split(" ");
// for (int j = 0; j < n; j++) {
// arr[j] = Integer.parseInt(temp[j]);
// }

// Arrays.sort(arr);
// marbles[i] = arr.clone();
// }
// Pair[] answer = new Pair[n];
// int idx = 0;

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// long v = marbles[1][j] - marbles[0][i];
// if (check(marbles[0][i], v)) {
// answer[idx++] = new Pair(marbles[0][i], v);
// break;
// }
// }
// }

// for (Pair pair : answer) {
// System.out.print(pair.x + " " + pair.v + "\n");
// }

// }
// }
