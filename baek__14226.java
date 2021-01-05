// import java.io.*;
// import java.util.*;

// class Node {
// int e;
// int c;

// Node(int e, int c) {
// this.e = e;
// this.c = c;

// }
// }

// class baek__14226 {

// static int MAX = 2000;

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int target = Integer.parseInt(br.readLine());
// int[][] dist = new int[MAX][MAX];

// for (int i = 0; i < MAX; i++) {
// for (int j = 0; j < MAX; j++) {
// dist[i][j] = -1;
// }
// }

// Queue<Node> q = new LinkedList<>();
// q.add(new Node(1, 0));
// dist[1][0] = 0;

// while (!q.isEmpty()) {
// Node cur = q.poll();
// int e = cur.e;
// int c = cur.c;

// int ne = e;
// int nc = e; // 복사하기
// if (ne >= 0 && ne < MAX && nc >= 0 && nc < MAX && dist[ne][nc] == -1) {
// q.add(new Node(ne, nc));
// dist[ne][nc] = dist[e][c] + 1;
// }
// ne = e + c;
// nc = c; // 붙여넣기
// if (c != 0 && ne >= 0 && ne < MAX && nc >= 0 && nc < MAX && dist[ne][nc] ==
// -1) {
// q.add(new Node(ne, nc));
// dist[ne][nc] = dist[e][c] + 1;
// }
// ne = e - 1;
// nc = c; // 삭제하기
// if (ne >= 0 && ne < MAX && nc >= 0 && nc < MAX && dist[ne][nc] == -1) {
// q.add(new Node(ne, nc));
// dist[ne][nc] = dist[e][c] + 1;
// }
// }

// int ans = -1;

// for (int i = 0; i < MAX; i++) {
// if (dist[target][i] == -1)
// continue;
// ans = ans == -1 ? dist[target][i] : Math.min(ans, dist[target][i]);
// }

// System.out.print(ans);

// }
// }