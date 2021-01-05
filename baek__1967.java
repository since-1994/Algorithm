// import java.io.*;
// import java.util.*;

// class Node {
// int point;
// int value;

// Node(int point, int value) {
// this.point = point;
// this.value = value;
// }
// }

// class Value {
// int h;
// int d;

// Value(int h, int d) {
// this.h = h;
// this.d = d;
// }
// }

// class baek__1967 {

// static ArrayList<Node>[] list;
// static boolean[] check;

// static Value go(int cur) {
// check[cur] = true;

// ArrayList<Integer> heights = new ArrayList<>();

// int diameter = -1;
// for (Node nex : list[cur]) {
// if (check[nex.point])
// continue;
// Value value = go(nex.point);

// diameter = Math.max(value.d, diameter);
// heights.add(value.h + nex.value);
// }

// Collections.sort(heights, Collections.reverseOrder());
// if (heights.size() == 0)
// return new Value(0, diameter);
// if (heights.size() == 1) {
// diameter = Math.max(diameter, heights.get(0));
// } else if (heights.size() >= 2) {
// diameter = Math.max(diameter, heights.get(0) + heights.get(1));
// }

// return new Value(heights.get(0), diameter);
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// list = new ArrayList[n + 1];
// check = new boolean[n + 1];

// for (int i = 0; i < n + 1; i++) {
// list[i] = new ArrayList<>();
// }

// String[] temp;
// for (int i = 0; i < n - 1; i++) {
// temp = br.readLine().split(" ");
// int u = Integer.parseInt(temp[0]);
// int v = Integer.parseInt(temp[1]);
// int value = Integer.parseInt(temp[2]);

// list[u].add(new Node(v, value));
// list[v].add(new Node(u, value));
// }

// System.out.print(go(1).d);
// }
// }