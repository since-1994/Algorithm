// import java.io.*;
// import java.util.*;

// class Node {
// int x;
// int limit;

// Node(int x, int limit) {
// this.x = x;
// this.limit = limit;
// }
// }

// class baek__1939 {
// static ArrayList<Node>[] list = new ArrayList[10001];
// static boolean[] check = new boolean[10001];

// static void bfs(int now, int weight) {
// if (check[now])
// return;

// check[now] = true;

// for (Node nex : list[now]) {
// if (nex.limit >= weight && !check[nex.x]) {
// bfs(nex.x, weight);
// }
// }
// }

// static boolean go(int weight, int start, int end) {

// Arrays.fill(check, false);
// bfs(start, weight);

// if (!check[end])
// return false;
// return true;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// int l = 1;
// int r = -1;

// for (int i = 0; i < n + 1; i++) {
// list[i] = new ArrayList<Node>();
// }

// for (int i = 0; i < m; i++) {
// temp = br.readLine().split(" ");
// int from = Integer.parseInt(temp[0]);
// int to = Integer.parseInt(temp[1]);
// int limit = Integer.parseInt(temp[2]);

// r = Math.max(limit, r);

// list[from].add(new Node(to, limit));
// list[to].add(new Node(from, limit));
// }

// temp = br.readLine().split(" ");
// int start = Integer.parseInt(temp[0]);
// int end = Integer.parseInt(temp[1]);
// int ans = -1;

// while (l <= r) {
// int mid = (l + r) / 2;

// if (go(mid, start, end)) {
// ans = mid;
// l = mid + 1;
// } else {
// r = mid - 1;
// }
// }

// System.out.print(ans);
// }
// }