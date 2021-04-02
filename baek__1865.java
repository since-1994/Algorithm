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

// class baek__1865 {
// static long MAX = 20000000000L;

// static boolean update_dist(long[] dist, Edge[] edges, boolean[] visited) {

// boolean updated = false;

// for (Edge edge : edges) {
// int start = edge.start;
// int end = edge.end;

// if (dist[start] == MAX)
// continue;

// if (dist[end] > dist[start] + edge.w) {
// visited[end] = true;
// updated = true;
// dist[end] = dist[start] + edge.w;
// }
// }

// return updated;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int tc = Integer.parseInt(br.readLine());

// StringBuilder sb = new StringBuilder();
// while (tc-- > 0) {
// String temp[] = br.readLine().split(" ");

// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);
// int w = Integer.parseInt(temp[2]);

// Edge[] edges = new Edge[2 * m + w];

// for (int i = 0; i < 2 * m; i += 2) {
// temp = br.readLine().split(" ");
// int v1 = Integer.parseInt(temp[0]);
// int v2 = Integer.parseInt(temp[1]);
// int weight = Integer.parseInt(temp[2]);

// edges[i] = new Edge(v1, v2, weight);
// edges[i + 1] = new Edge(v2, v1, weight);
// }

// for (int i = 2 * m; i < 2 * m + w; i++) {
// temp = br.readLine().split(" ");
// int start = Integer.parseInt(temp[0]);
// int end = Integer.parseInt(temp[1]);
// int weight = Integer.parseInt(temp[2]);

// edges[i] = new Edge(start, end, -weight);
// }

// long[] dist = new long[n + 1];
// boolean[] visited = new boolean[n + 1];
// boolean timeback = false;

// for (int i = 1; i <= n; i++) {
// if (visited[i])
// continue;

// Arrays.fill(dist, MAX);
// dist[i] = 0L;
// visited[i] = true;

// for (int j = 0; j < n - 1; j++) {
// update_dist(dist, edges, visited);
// }
// if (update_dist(dist, edges, visited)) {
// timeback = true;
// break;
// }
// }

// sb.append(timeback ? "YES" : "NO");
// sb.append("\n");

// }
// System.out.print(sb);
// }
// }
