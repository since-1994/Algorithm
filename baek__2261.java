// import java.io.*;
// import java.util.*;

// class Pair {
// int x;
// int y;

// Pair(int x, int y) {
// this.x = x;
// this.y = y;
// }
// }

// class ComparatorX implements Comparator<Pair> {
// public int compare(Pair u, Pair v) {
// if (u.x < v.x) {
// return -1;
// } else if (u.x == v.x) {
// return 0;
// } else {
// return 1;
// }
// }
// }

// class ComparatorY implements Comparator<Pair> {
// public int compare(Pair u, Pair v) {
// if (u.y < v.y) {
// return -1;
// } else if (u.y == v.y) {
// return 0;
// } else {
// return 1;
// }
// }
// }

// class baek__2261 {
// static Pair[] pairs;

// static int merge(int start, int end, int d) {
// ArrayList<Pair> targets = new ArrayList<>();
// int mid = (start + end) / 2;

// for (int i = start; i <= end; i++) {
// if ((pairs[mid].x - pairs[i].x) * (pairs[mid].x - pairs[i].x) < d) {
// targets.add(pairs[i]);
// }
// }

// Collections.sort(targets, new ComparatorY());

// for (int i = 0; i < targets.size() - 1; i++) {
// for (int j = i + 1; j < targets.size(); j++) {
// if ((targets.get(j).y - targets.get(i).y) * (targets.get(j).y -
// targets.get(i).y) < d) {
// d = Math.min(d, (targets.get(j).y - targets.get(i).y) * (targets.get(j).y -
// targets.get(i).y)
// + (targets.get(j).x - targets.get(i).x) * (targets.get(j).x -
// targets.get(i).x));
// } else {
// break;
// }
// }
// }

// return d;

// }

// static int go(int start, int end) {

// if (end - start + 1 <= 3) {
// int ans = -1;
// for (int i = start; i <= end - 1; i++) {
// for (int j = i + 1; j <= end; j++) {
// int temp = (pairs[i].x - pairs[j].x) * (pairs[i].x - pairs[j].x)
// + (pairs[i].y - pairs[j].y) * (pairs[i].y - pairs[j].y);
// ans = ans == -1 ? temp : Math.min(temp, ans);
// }
// }
// return ans;
// }

// int mid = (start + end) / 2;
// int d1 = go(start, mid);
// int d2 = go(mid + 1, end);
// int d = Math.min(d1, d2);

// return merge(start, end, d);
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());

// pairs = new Pair[n];

// String[] temp;
// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// int x = Integer.parseInt(temp[0]);
// int y = Integer.parseInt(temp[1]);
// pairs[i] = new Pair(x, y);
// }

// Arrays.sort(pairs, new ComparatorX());
// System.out.print(go(0, pairs.length - 1));
// }
// }