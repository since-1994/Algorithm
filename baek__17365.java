// import java.io.*;
// import java.util.*;

// class Pair {
// boolean prefix;
// int cnt;

// Pair(boolean prefix, int cnt) {
// this.prefix = prefix;
// this.cnt = cnt;
// }
// }

// class Node {
// int[] children;
// int count;

// Node() {
// children = new int[26];
// Arrays.fill(children, -1);
// count = 0;
// }
// }

// class Trie {
// ArrayList<Node> trie;
// int root;

// int init() {
// Node x = new Node();
// trie.add(x);
// return trie.size() - 1;
// }

// Trie() {
// trie = new ArrayList<>();
// root = init();
// }

// void add(String s, int idx, int cur) {
// if (idx == s.length()) {
// trie.get(cur).count++;
// return;
// }

// int c = s.charAt(idx) - 'a';
// if (trie.get(cur).children[c] == -1) {
// int nex = init();
// trie.get(cur).children[c] = nex;
// }
// if (cur != root)
// trie.get(cur).count++;

// int nex = trie.get(cur).children[c];
// add(s, idx + 1, nex);
// }

// void add(String s) {
// add(s, 0, root);
// }

// Pair search(String s, int idx, int cur) {
// if (idx == s.length()) {
// return new Pair(true, trie.get(cur).count);
// }

// int c = s.charAt(idx) - 'a';
// if (trie.get(cur).children[c] == -1) {
// return new Pair(false, -1);
// }
// int nex = trie.get(cur).children[c];
// return search(s, idx + 1, nex);
// }

// Pair search(String s) {
// return search(s, 0, root);// 0번째에 0이라고 생각하자.
// }
// }

// class baek__17365 {
// static long m = 1000000007;
// static Trie trie;
// static String s;
// static long[] d;

// static long go(int start) {
// if (start >= s.length()) {
// return 1;
// }

// if (d[start] != -1) {
// return d[start];
// }

// d[start] = 0;

// for (int i = start; i < s.length(); i++) {
// if (i - start + 1 > 300)
// break;
// String t = s.substring(start, i + 1);
// Pair pair = trie.search(t);
// if (pair.prefix) {
// d[start] += pair.cnt * go(i + 1) % m;
// d[start] %= m;
// } else {
// return d[start];
// }
// }

// return d[start];
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// trie = new Trie();
// for (int i = 0; i < n; i++) {
// trie.add(br.readLine());
// }
// s = br.readLine();
// d = new long[s.length()];
// Arrays.fill(d, -1);

// System.out.println(go(0));
// }
// }
