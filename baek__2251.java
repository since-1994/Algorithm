// import java.io.*;
// import java.util.*;

// class Node {
// int a;
// int b;

// Node(int a, int b) {
// this.a = a;
// this.b = b;
// }
// }

// class baek__2251 {
// static int total = 0;
// static int[] cap;
// static ArrayList<Integer> c = new ArrayList<>();

// static void dfs(Node start, boolean[][] check) {
// check[start.a][start.b] = true;
// int[] now = { start.a, start.b, total - start.a - start.b };
// if (start.a == 0)
// c.add(now[2]);

// for (int i = 0; i < 3; i++) {
// for (int j = 0; j < 3; j++) {
// if (i == j)
// continue;
// int[] nex = now.clone();
// nex[j] += nex[i];
// nex[i] = 0;
// if (nex[j] > cap[j]) {
// nex[i] += nex[j] - cap[j];
// nex[j] = cap[j];
// }
// if (check[nex[0]][nex[1]])
// continue;
// dfs(new Node(nex[0], nex[1]), check);
// }
// }

// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");

// cap = new int[3];

// cap[0] = Integer.parseInt(temp[0]);
// cap[1] = Integer.parseInt(temp[1]);
// cap[2] = Integer.parseInt(temp[2]);

// total = cap[2];

// boolean[][] check = new boolean[201][201];

// dfs(new Node(0, 0), check);
// Collections.sort(c);

// for (int i = 0; i < c.size(); i++) {
// System.out.print(c.get(i) + " ");
// }
// }
// }