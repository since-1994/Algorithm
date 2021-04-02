// import java.io.*;
// import java.util.*;

// class Edge {
// int v1;
// int v2;
// int w;

// Edge(int v1, int v2, int w) {
// this.v1 = v1;
// this.v2 = v2;
// this.w = w;
// }
// }

// class Desc implements Comparator<Edge> {

// public int compare(Edge a, Edge b) {
// Integer u = a.w;
// Integer v = b.w;
// return u.compareTo(v);
// }
// }

// class baek__6091 {

// static int find(int x, int[] parent) {
// return x == parent[x] ? parent[x] : (parent[x] = find(parent[x], parent));
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// int[] parent = new int[n + 1];

// for (int i = 1; i < n + 1; i++) {
// parent[i] = i;
// }

// ArrayList<Edge> edge_candidates = new ArrayList<>();

// String[] temp;
// for (int i = 1; i < n; i++) {
// temp = br.readLine().split(" ");
// for (int j = i + 1; j < n + 1; j++) {
// edge_candidates.add(new Edge(i, j, Integer.parseInt(temp[j - i - 1])));
// }
// }
// Collections.sort(edge_candidates, new Desc());

// ArrayList<Integer>[] list = new ArrayList[n + 1];

// for (int i = 1; i < n + 1; i++) {
// list[i] = new ArrayList<>();
// }

// for (Edge candidate : edge_candidates) {
// int v1 = candidate.v1;
// int v2 = candidate.v2;

// int r1 = find(v1, parent);
// int r2 = find(v2, parent);

// if (r1 == r2)
// continue;

// parent[r1] = r2;
// list[v1].add(v2);
// list[v2].add(v1);
// }

// StringBuilder sb = new StringBuilder();

// for (int i = 1; i <= n; i++) {
// sb.append(list[i].size() + " ");
// Collections.sort(list[i]);
// for (int j : list[i]) {
// sb.append(j + " ");
// }
// sb.append("\n");
// }

// System.out.print(sb);
// }
// }
