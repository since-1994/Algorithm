// import java.io.*;
// import java.util.*;

// class Hash {

// String s;
// long[] hash;
// long[] power;
// int r;
// int m;

// Hash(String s, int r, int m) {
// this.s = s;
// this.r = r;
// this.m = m;
// hash = new long[s.length() + 1];
// power = new long[s.length() + 1];
// power[0] = 1;
// for (int i = 1; i < s.length() + 1; i++) {
// power[i] = power[i - 1] * r;
// power[i] %= m;
// }
// hash[s.length()] = 0;
// hash[s.length() - 1] = (s.charAt(s.length() - 1) - 'a' + 1);
// for (int i = s.length() - 2; i >= 0; i--) {
// hashing(i);
// }
// }

// int get(int left, int right) {
// long value = hash[left] - hash[right] * power[right - left] % m;
// value += m;
// value %= m;
// return (int) value;
// }

// void hashing(int idx) {
// int c = s.charAt(idx) - 'a' + 1;
// hash[idx] = hash[idx + 1] * r % m + c;
// hash[idx] %= m;
// }
// }

// class baek__13276 {
// static int r1 = 31;
// static int r2 = 127;

// static int m = 1000000007;

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String s = br.readLine();
// Hash hash1 = new Hash(s, r1, m);
// Hash hash2 = new Hash(s, r2, m);

// String pre = br.readLine();
// String suf = br.readLine();

// Hash pre1 = new Hash(pre, r1, m);
// Hash pre2 = new Hash(pre, r2, m);

// Hash suf1 = new Hash(suf, r1, m);
// Hash suf2 = new Hash(suf, r2, m);

// HashSet<String> set = new HashSet<>();

// for (int i = 0; i < s.length(); i++) {
// for (int j = i; j < s.length(); j++) {
// if (j - i + 1 < pre.length() || j - i + 1 < suf.length())
// continue;
// if (pre.length() + i > s.length() || j - suf.length() + 1 < 0)
// continue;
// int a1 = hash1.get(i, pre.length() + i);
// int a2 = hash2.get(i, pre.length() + i);

// int b1 = pre1.get(0, pre.length());
// int b2 = pre2.get(0, pre.length());

// int a3 = hash1.get(j - suf.length() + 1, j + 1);
// int a4 = hash2.get(j - suf.length() + 1, j + 1);

// int b3 = suf1.get(0, suf.length());
// int b4 = suf2.get(0, suf.length());

// if (a1 == b1 && a2 == b2 && a3 == b3 && a4 == b4) {
// set.add(s.substring(i, j + 1));
// }
// }
// }

// System.out.print(set.size());
// }
// }
