// import java.io.*;
// import java.util.*;

// class Pair implements Comparable<Pair> {
// int x;
// int l;

// Pair(int x, int l) {
// this.x = x;
// this.l = l;
// }

// public int compareTo(Pair that) {
// if (this.x < that.x)
// return -1;
// else if (this.x == that.x) {
// Integer u = this.l;
// Integer v = that.l;

// return u.compareTo(v);
// }
// return 1;
// }
// }

// class baek__17976 {
// static int n;
// static ArrayList<Pair> pairs;

// static boolean check(long minD) {
// int now = pairs.get(0).x;

// for (int i = 1; i < n; i++) {
// if (pairs.get(i).x - now < minD) {
// if (now + minD <= pairs.get(i).x + pairs.get(i).l) {
// now += minD;
// } else {
// return false;
// }
// } else {
// now = pairs.get(i).x;
// }
// }

// return true;
// }

// static void shuffleRandom(Pair[] pairs) {
// Random random = new Random();

// for (int i = pairs.length - 1; i > 0; i--) {
// int idx = random.nextInt(i + 1);
// Pair temp = pairs[idx];
// pairs[idx] = pairs[i];
// pairs[i] = temp;
// }
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// n = Integer.parseInt(br.readLine());
// pairs = new ArrayList<>();

// String[] temp;
// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// pairs.add(new Pair(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
// }
// Collections.sort(pairs);
// long l = -1;
// long r = pairs.get(pairs.size() - 1).x + pairs.get(pairs.size() - 1).l -
// pairs.get(0).x + 1;

// while (l + 1 < r) {
// long mid = (l + r) / 2;

// if (check(mid)) {
// l = mid;
// } else {
// r = mid;
// }
// }

// System.out.print(l);

// }
// }
