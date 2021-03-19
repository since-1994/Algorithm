// import java.io.*;
// import java.util.*;

// class Node {
// int t;
// int x;

// Node(int t, int x) {
// this.t = t;
// this.x = x;
// }
// }

// class lin__19__q1__1 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int cony_start = Integer.parseInt(temp[0]);
// int brown_start = Integer.parseInt(temp[1]);

// int[] cony_visit = new int[200001];

// Arrays.fill(cony_visit, -1);
// cony_visit[cony_start] = 0;
// cony_visit[cony_start + 1] = 1;
// int t = 2;
// int x = cony_start + 1;
// while (x + t <= 200000) {
// cony_visit[x + t] = t;
// x += t;
// t += 1;
// }

// boolean[][] check = new boolean[t][200001];
// Queue<Node> q = new LinkedList<>();

// q.add(new Node(0, brown_start));
// check[0][brown_start] = true;

// while (!q.isEmpty()) {
// Node now = q.poll();

// if (cony_visit[now.x] == now.t) {
// System.out.print(cony_visit[now.x]);
// return;
// }

// int nextTime = now.t + 1;
// if (nextTime >= t)
// continue;

// int nextPosition = now.x + 1;
// if (nextPosition <= 200000 && !check[nextTime][nextPosition]) {
// q.add(new Node(nextTime, nextPosition));
// check[nextTime][nextPosition] = true;
// }

// nextPosition = now.x - 1;
// if (nextPosition >= 0 && !check[nextTime][nextPosition]) {
// q.add(new Node(nextTime, nextPosition));
// check[nextTime][nextPosition] = true;
// }

// nextPosition = now.x * 2;
// if (nextPosition <= 200000 && !check[nextTime][nextPosition]) {
// q.add(new Node(nextTime, nextPosition));
// check[nextTime][nextPosition] = true;
// }
// }

// System.out.print(-1);
// }
// }
