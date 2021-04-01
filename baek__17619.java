// import java.io.*;
// import java.util.*;

// class Node implements Comparable<Node> {
// int x1;
// int x2;
// int idx;

// Node(int idx, int x1, int x2) {
// this.idx = idx;
// this.x1 = x1;
// this.x2 = x2;
// }

// public int compareTo(Node that) {
// if (this.x1 < that.x1) {
// return -1;
// } else if (this.x1 == that.x1) {
// return 0;
// }
// return 1;
// }
// }

// class baek__17619 {

// static int find(int a, int[] parent) {
// return a == parent[a] ? a : (parent[a] = find(parent[a], parent));
// }

// static void union(int a, int b, int[] parent, int[] size) {
// int r1 = find(a, parent);
// int r2 = find(b, parent);

// if (size[r1] > size[r2]) {
// int temp = r1;
// r1 = r2;
// r2 = temp;
// }

// parent[r1] = r2;
// size[r2] += size[r1];
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// String[] temp = br.readLine().split(" ");

// int n = Integer.parseInt(temp[0]);
// int[] parent = new int[n + 1];
// int[] size = new int[n + 1];
// Node[] nodes = new Node[n + 1];
// for (int i = 1; i <= n; i++) {
// parent[i] = i;
// size[i] = 1;
// }
// int q = Integer.parseInt(temp[1]);

// nodes[0] = new Node(-1, -1, -1);
// for (int i = 1; i <= n; i++) {
// temp = br.readLine().split(" ");
// nodes[i] = new Node(i, Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
// }

// Arrays.sort(nodes);

// for (int i = 1; i <= n; i++) {
// for (int j = i + 1; j <= n; j++) {
// if (nodes[i].x2 >= nodes[j].x1) {
// union(nodes[i].idx, nodes[j].idx, parent, size);
// } else {
// break;
// }
// }
// }

// StringBuilder sb = new StringBuilder();
// while (q-- > 0) {
// temp = br.readLine().split(" ");
// int u = Integer.parseInt(temp[0]);
// int v = Integer.parseInt(temp[1]);

// int r1 = find(u, parent);
// int r2 = find(v, parent);

// if (r1 == r2) {
// sb.append(1 + "\n");
// } else {
// sb.append(0 + "\n");
// }
// }
// System.out.print(sb);
// }
// }
