// import java.io.*;
// import java.util.*;

// class Edge {
// int v1;
// int v2;
// String c;

// Edge(int v1, int v2, String c) {
// this.v1 = v1;
// this.v2 = v2;
// this.c = c;
// }
// }

// class blueFirst implements Comparator<Edge> {
// public int compare(Edge e1, Edge e2) {
// if (e1.c.equals("B"))
// return -1;
// if (e2.c.equals("B"))
// return 1;
// return 0;
// }
// }

// class redFirst implements Comparator<Edge> {
// public int compare(Edge e1, Edge e2) {
// if (e1.c.equals("R"))
// return -1;
// if (e2.c.equals("R"))
// return 1;
// return 0;
// }
// }

// class baek__4792 {

// static int find(int x, int[] parent) {
// return parent[x] == x ? x : find(parent[x], parent);
// }

// static int getBlueEdge(Edge[] edges, String color, int n) {

// if (color.equals("R")) {
// Arrays.sort(edges, new redFirst());
// } else {
// Arrays.sort(edges, new blueFirst());
// }

// int[] parent = new int[n + 1];

// for (int i = 1; i < n + 1; i++)
// parent[i] = i;

// int cnt = 0;

// for (Edge edge : edges) {
// int r1 = find(edge.v1, parent);
// int r2 = find(edge.v2, parent);

// if (r1 == r2)
// continue;

// if (edge.c.equals("B"))
// cnt++;
// parent[r2] = r1;
// }

// return cnt;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp;

// StringBuilder sb = new StringBuilder();

// while (true) {
// temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);
// int k = Integer.parseInt(temp[2]);

// if (n == 0 && m == 0 && k == 0)
// break;

// Edge[] edges = new Edge[m];

// for (int i = 0; i < m; i++) {
// temp = br.readLine().split(" ");
// String c = temp[0];
// int f = Integer.parseInt(temp[1]);
// int t = Integer.parseInt(temp[2]);

// edges[i] = new Edge(f, t, c);
// }

// int min = getBlueEdge(edges, "R", n);
// int max = getBlueEdge(edges, "B", n);

// if (min <= k && max >= k)
// sb.append(1 + "\n");
// else
// sb.append(0 + "\n");
// }

// System.out.print(sb);
// }
// }
