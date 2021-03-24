// import java.io.*;
// import java.util.*;

// class Node {
// int x;
// int w;

// Node(int x, int w) {
// this.x = x;
// this.w = w;
// }
// }

// class baek__1939 {
// static int MAX = 1000000000;

// static boolean possible(int now, int target, long weight, ArrayList<Node>[]
// list, boolean[] check) {
// check[now] = true;

// if (now == target) {
// return true;
// }

// boolean value = false;

// for (Node next : list[now]) {
// if (check[next.x])
// continue;

// if (next.w < weight)
// continue;

// if (possible(next.x, target, weight, list, check)) {
// value = true;
// }
// }

// return value;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");

// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// ArrayList<Node>[] list = new ArrayList[n];

// for (int i = 0; i < n; i++) {
// list[i] = new ArrayList<>();
// }

// while (m-- > 0) {
// temp = br.readLine().split(" ");
// int a = Integer.parseInt(temp[0]);
// a -= 1;
// int b = Integer.parseInt(temp[1]);
// b -= 1;
// int c = Integer.parseInt(temp[2]);

// list[a].add(new Node(b, c));
// list[b].add(new Node(a, c));
// }

// temp = br.readLine().split(" ");
// int start = Integer.parseInt(temp[0]);
// start -= 1;
// int target = Integer.parseInt(temp[1]);
// target -= 1;

// long l = -1;
// long r = MAX + 1;

// while (l + 1 < r) {
// long mid = (l + r) / 2;

// boolean[] check = new boolean[n + 1];

// if (possible(start, target, mid, list, check)) {
// l = mid;
// } else {
// r = mid;
// }
// }

// System.out.print(l);
// }
// }
