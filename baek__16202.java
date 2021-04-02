// import java.io.*;
// import java.util.*;

// class Edge implements Comparable<Edge> {
// int v1;
// int v2;
// int w;

// Edge(int v1, int v2, int w) {
// this.v1 = v1;
// this.v2 = v2;
// this.w = w;
// }

// public int compareTo(Edge that) {
// Integer u = this.w;
// Integer v = that.w;

// return u.compareTo(v);
// }
// }

// class baek__16202 {

// static int find(int x, int[] parent) {
// return x == parent[x] ? parent[x] : (parent[x] = find(parent[x], parent));
// }

// static int getSMTValue(PriorityQueue<Edge> edges, int n, int[] parent) {
// ArrayList<Edge> list = new ArrayList<>();

// for (int i = 1; i < n + 1; i++) {
// parent[i] = i;
// }

// int tot = 0;
// int min = -1;

// while (!edges.isEmpty()) {
// Edge edge = edges.poll();
// int r1 = find(edge.v1, parent);
// int r2 = find(edge.v2, parent);

// if (r1 == r2) {
// list.add(edge);
// continue;
// }

// if (min == -1) {
// min = edge.w;
// } else {
// list.add(edge);
// }

// tot += edge.w;
// parent[r1] = r2;
// }

// for (int i = 2; i < n + 1; i++) {
// if (find(i - 1, parent) != find(i, parent)) {
// return -1;
// }
// }

// for (Edge edge : list) {
// edges.add(edge);
// }

// return tot;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");

// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);
// int k = Integer.parseInt(temp[2]);

// PriorityQueue<Edge> edges = new PriorityQueue<>();

// for (int i = 1; i < m + 1; i++) {
// temp = br.readLine().split(" ");
// int v1 = Integer.parseInt(temp[0]);
// int v2 = Integer.parseInt(temp[1]);
// edges.add(new Edge(v1, v2, i));
// }

// boolean possible = true;
// int[] parent = new int[n + 1];

// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < k; i++) {
// if (!possible) {
// sb.append(0 + " ");
// continue;
// }

// int tot = getSMTValue(edges, n, parent);
// if (tot == -1) {
// possible = false;
// sb.append(0 + " ");
// } else {
// sb.append(tot + " ");
// }
// }

// System.out.print(sb);
// }
// }
