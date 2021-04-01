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

// class baek__1197 {

// static int find(int n, int[] parent) {
// return parent[n] == n ? parent[n] : (parent[n] = find(parent[n], parent));
// }

// static void union(int a, int b, int[] parent) {
// int r1 = find(a, parent);
// int r2 = find(b, parent);

// parent[r1] = r2;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");

// int v = Integer.parseInt(temp[0]);
// int e = Integer.parseInt(temp[1]);

// int[] parent = new int[v + 1];
// Edge[] edges = new Edge[e];
// for (int i = 1; i <= v; i++) {
// parent[i] = i;
// }

// for (int i = 0; i < e; i++) {
// temp = br.readLine().split(" ");

// int a = Integer.parseInt(temp[0]);
// int b = Integer.parseInt(temp[1]);
// int w = Integer.parseInt(temp[2]);

// edges[i] = new Edge(a, b, w);
// }

// Arrays.sort(edges);

// int answer = 0;

// for (Edge edge : edges) {
// int a = edge.v1;
// int b = edge.v2;

// int r1 = find(a, parent);
// int r2 = find(b, parent);

// if (r1 == r2)
// continue;

// answer += edge.w;
// union(r1, r2, parent);
// }

// System.out.print(answer);

// }
// }
