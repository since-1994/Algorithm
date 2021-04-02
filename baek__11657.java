// import java.io.*;
// import java.util.*;

// class Edge {
// int start;
// int end;
// int w;

// Edge(int start, int end, int w) {
// this.start = start;
// this.end = end;
// this.w = w;
// }
// }

// class baek__11657 {

// static int MAX = 2000000000;

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");

// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// Edge[] edges = new Edge[m];

// for (int i = 0; i < m; i++) {
// temp = br.readLine().split(" ");
// int u = Integer.parseInt(temp[0]);
// int v = Integer.parseInt(temp[1]);
// int w = Integer.parseInt(temp[2]);
// edges[i] = new Edge(u, v, w);
// }

// int[] dist = new int[n + 1];

// Arrays.fill(dist, MAX);
// dist[1] = 0;

// for (int i = 0; i < n - 1; i++) {
// for (Edge edge : edges) {
// int start = edge.start;
// int end = edge.end;

// if (dist[start] == MAX)
// continue;

// if (dist[end] > dist[start] + edge.w) {
// dist[end] = dist[start] + edge.w;
// }
// }
// }
// for (Edge edge : edges) {
// int start = edge.start;
// int end = edge.end;

// if (dist[start] == MAX)
// continue;

// if (dist[end] > dist[start] + edge.w) {
// System.out.print(-1);
// return;
// }
// }

// for (int i = 2; i < n + 1; i++) {
// System.out.println(dist[i] == MAX ? -1 : dist[i]);
// }
// }
// }
