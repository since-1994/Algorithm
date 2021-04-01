// import java.io.*;
// import java.util.*;

// class Node {
// int x;
// int least_length;

// Node(int x, int least_length) {
// this.x = x;
// this.least_length = least_length;
// }
// }

// class baek__18780 {
// static long[] d;
// static int[] least_occurred_day;
// static int m;

// static long go(int n, ArrayList<Node>[] list) {
// if (list[n].size() == 0) {
// return least_occurred_day[n];
// }

// if (d[n] != -1)
// return d[n];

// for (Node before : list[n]) {
// long day = go(before.x, list) + before.least_length;
// d[n] = d[n] == -1 ? day : Math.max(d[n], day);
// }

// if (d[n] < least_occurred_day[n])
// d[n] = least_occurred_day[n];

// return d[n];
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// m = Integer.parseInt(temp[1]);
// int c = Integer.parseInt(temp[2]);

// temp = br.readLine().split(" ");
// least_occurred_day = new int[n + 1];

// for (int i = 1; i < n + 1; i++) {
// least_occurred_day[i] = Integer.parseInt(temp[i - 1]);
// }

// ArrayList<Node>[] list = new ArrayList[n + 1];

// for (int i = 1; i < n + 1; i++) {
// list[i] = new ArrayList<>();
// }

// while (c-- > 0) {
// temp = br.readLine().split(" ");
// int a = Integer.parseInt(temp[0]);
// int b = Integer.parseInt(temp[1]);
// int x = Integer.parseInt(temp[2]);

// list[b].add(new Node(a, x));
// }

// d = new long[n + 1];
// Arrays.fill(d, -1);

// for (int i = 1; i < n + 1; i++) {
// System.out.println(go(i, list));
// }
// }
// }
