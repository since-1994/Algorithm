// import java.io.*;
// import java.util.*;

// class Pair implements Comparable<Pair> {
// long hash1;
// long hash2;

// Pair(long hash1, long hash2) {
// this.hash1 = hash1;
// this.hash2 = hash2;
// }

// public int compareTo(Pair that) {
// if (this.hash1 < that.hash1) {
// return -1;
// } else if (this.hash1 == that.hash1) {
// Long u = (Long) this.hash2;
// Long v = (Long) that.hash2;
// return u.compareTo(v);
// }
// return 1;
// }
// }

// class baek__10840 {
// static String s;
// static String t;

// static int r1 = 127;
// static int r2 = 31;
// static int m1 = 1000000007;
// static int m2 = 1234567891;

// static long[] hashS1;
// static long[] hashS2;
// static long[] hashT1;
// static long[] hashT2;

// static boolean find(ArrayList<Pair> list, Pair pair) {
// int l = -1;
// int r = list.size();

// while (l + 1 < r) {
// int mid = (l + r) / 2;
// if (list.get(mid).hash1 < pair.hash1) {
// l = mid;
// } else if (list.get(mid).hash1 == pair.hash1) {
// if (list.get(mid).hash2 < pair.hash2) {
// l = mid;
// } else {
// r = mid;
// }
// } else {
// r = mid;
// }
// }
// if (r == list.size()) {
// return false;
// }
// if (list.get(r).hash1 == pair.hash1 && list.get(r).hash2 == pair.hash2) {
// return true;
// }
// return false;
// }

// static boolean check(int len) {
// ArrayList<Pair> list1 = new ArrayList<>();
// for (int i = 0; i < s.length() - len + 1; i++) {
// long a1 = i - 1 == -1 ? hashS1[i + len - 1] : hashS1[i + len - 1] - hashS1[i
// - 1];
// a1 += m1;
// a1 %= m1;
// long a2 = i - 1 == -1 ? hashS2[i + len - 1] : hashS2[i + len - 1] - hashS2[i
// - 1];
// a2 += m2;
// a2 %= m2;
// list1.add(new Pair(a1, a2));
// }
// Collections.sort(list1);
// ArrayList<Pair> list2 = new ArrayList<>();

// for (int i = 0; i < t.length() - len + 1; i++) {
// long b1 = i - 1 == -1 ? hashT1[i + len - 1] : hashT1[i + len - 1] - hashT1[i
// - 1];
// b1 += m1;
// b1 %= m1;
// long b2 = i - 1 == -1 ? hashT2[i + len - 1] : hashT2[i + len - 1] - hashT2[i
// - 1];
// b2 += m2;
// b2 %= m2;
// list2.add(new Pair(b1, b2));
// }

// for (int i = 0; i < list2.size(); i++) {
// if (find(list1, list2.get(i))) {
// return true;
// }
// }

// return false;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// s = br.readLine();
// t = br.readLine();

// long[] power1 = new long[26];
// long[] power2 = new long[26];

// power1[0] = 1;
// power2[0] = 1;
// for (int i = 1; i < 26; i++) {
// power1[i] = power1[i - 1] * r1;
// power1[i] %= m1;

// power2[i] = power2[i - 1] * r2;
// power2[i] %= m2;
// }

// hashS1 = new long[s.length()];
// hashS2 = new long[s.length()];
// hashT1 = new long[t.length()];
// hashT2 = new long[t.length()];

// hashS1[0] = power1[s.charAt(0) - 'a'];
// hashS2[0] = power2[s.charAt(0) - 'a'];
// hashT1[0] = power1[t.charAt(0) - 'a'];
// hashT2[0] = power2[t.charAt(0) - 'a'];

// for (int i = 1; i < s.length(); i++) {
// hashS1[i] = hashS1[i - 1] + power1[s.charAt(i) - 'a'];
// hashS1[i] %= m1;

// hashS2[i] = hashS2[i - 1] + power2[s.charAt(i) - 'a'];
// hashS2[i] %= m2;
// }

// for (int i = 1; i < t.length(); i++) {
// hashT1[i] = hashT1[i - 1] + power1[t.charAt(i) - 'a'];
// hashT1[i] %= m1;

// hashT2[i] = hashT2[i - 1] + power2[t.charAt(i) - 'a'];
// hashT2[i] %= m2;
// }

// for (int i = Math.min(s.length(), t.length()); i >= 1; i--) {
// if (check(i)) {
// System.out.print(i);
// return;
// }
// }

// System.out.print(0);
// }
// }
