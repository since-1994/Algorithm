// import java.io.*;
// import java.util.*;

// class Pair {
// int x;
// int h;

// Pair(int x, int h) {
// this.x = x;
// this.h = h;
// }
// }

// class Result {
// ArrayList<Pair> ans;

// Result() {
// ans = new ArrayList<Pair>();
// }

// int size() {
// return ans.size();
// }

// Pair get(int idx) {
// return ans.get(idx);
// }

// void append(Pair p) {
// int n = ans.size();
// if (n > 0) {
// if (ans.get(n - 1).h == p.h) {
// return;
// } else {
// if (ans.get(n - 1).x == p.x) {
// ans.set(n - 1, p);
// return;
// }
// }
// }
// ans.add(p);
// }

// void printAns() {
// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < ans.size(); i++) {
// sb.append(ans.get(i).x + " " + ans.get(i).h + " ");
// }
// System.out.print(sb);
// }

// }

// class Building implements Comparable<Building> {
// int left;
// int height;
// int right;

// Building(int left, int height, int right) {
// this.left = left;
// this.height = height;
// this.right = right;
// }

// public int compareTo(Building that) {
// if (this.left < that.left) {
// return -1;
// } else if (this.left == that.left) {
// if (this.height < that.height) {
// return -1;
// } else if (this.height == that.height) {
// if (this.right < that.right) {
// return -1;
// } else if (this.right == that.right) {
// return 0;
// } else {
// return 1;
// }
// } else {
// return 1;
// }
// } else {
// return 1;
// }
// }
// }

// class baek__1933 {
// static Building[] buildings;

// static Result merge(Result l, Result r) {

// Result ans = new Result();

// int i = 0;
// int j = 0;
// int h1 = 0;
// int h2 = 0;
// // l.printAns();
// // System.out.println();
// // r.printAns();
// // System.out.println();

// while (i < l.size() && j < r.size()) {
// if (l.get(i).x < r.get(j).x) {
// h1 = l.get(i).h;
// int x = l.get(i).x;
// int h = Math.max(h1, h2);
// ans.append(new Pair(x, h));
// i += 1;
// } else {
// h2 = r.get(j).h;
// int x = r.get(j).x;
// int h = Math.max(h1, h2);
// ans.append(new Pair(x, h));
// j += 1;
// }
// }

// while (i < l.size()) {
// ans.append(new Pair(l.get(i).x, l.get(i).h));
// i += 1;
// }
// while (j < r.size()) {
// ans.append(new Pair(r.get(j).x, r.get(j).h));
// j += 1;
// }
// // ans.printAns();
// // System.out.println();
// // System.out.println();

// return ans;
// }

// static Result go(int start, int end) {
// if (start == end) {
// Result ans = new Result();
// Building building = buildings[start];

// ans.append(new Pair(building.left, building.height));
// ans.append(new Pair(building.right, 0));

// return ans;
// }

// int mid = (start + end) / 2;
// return merge(go(start, mid), go(mid + 1, end));
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());

// buildings = new Building[n];

// for (int i = 0; i < n; i++) {
// String[] temp = br.readLine().split(" ");
// int left = Integer.parseInt(temp[0]);
// int height = Integer.parseInt(temp[1]);
// int right = Integer.parseInt(temp[2]);

// buildings[i] = new Building(left, height, right);
// }

// Arrays.sort(buildings);
// go(0, n - 1).printAns();
// }
// }