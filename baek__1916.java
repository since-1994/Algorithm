// import java.io.*;
// import java.util.*;

// class Pair implements Comparable<Pair> {
// int x;
// int dist;

// Pair(int x, int dist) {
// this.x = x;
// this.dist = dist;
// }

// public int compareTo(Pair that) {
// Integer u = this.x;
// Integer v = that.x;
// return u.compareTo(v);
// }
// }

// class baek__1916 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// int m = Integer.parseInt(br.readLine());
// String[] temp;

// ArrayList<Pair>[] list = new ArrayList[n + 1];
// for (int i = 1; i <= n; i++) {
// list[i] = new ArrayList<>();
// }

// int[] answer = new int[n + 1];
// Arrays.fill(answer, -1);

// for (int i = 0; i < m; i++) {
// temp = br.readLine().split(" ");
// int from = Integer.parseInt(temp[0]);
// int to = Integer.parseInt(temp[1]);
// int between = Integer.parseInt(temp[2]);

// list[from].add(new Pair(to, between));
// }

// temp = br.readLine().split(" ");
// int start = Integer.parseInt(temp[0]);
// int end = Integer.parseInt(temp[1]);
// answer[start] = 0;

// PriorityQueue<Pair> q = new PriorityQueue<>();
// q.add(new Pair(start, 0));
// answer[start] = 0;

// while (!q.isEmpty()) {
// Pair now = q.poll();
// if (now.dist > answer[now.x])
// continue;

// for (Pair next : list[now.x]) {
// if (answer[next.x] == -1 || now.dist + next.dist < answer[next.x]) {
// answer[next.x] = now.dist + next.dist;
// q.add(new Pair(next.x, answer[next.x]));
// }
// }
// }
// System.out.print(answer[end]);

// }
// }
