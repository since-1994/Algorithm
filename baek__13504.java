// import java.io.*;
// import java.util.*;

// class Node {
// int[] children;
// boolean valid;

// Node() {
// children = new int[2];
// Arrays.fill(children, -1);
// valid = false;
// }
// }

// class Trie {
// ArrayList<Node> trie = new ArrayList<>();
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

// void add(int n, int idx, int cur) {
// if (idx == -1) {
// trie.get(cur).valid = true;
// return;
// }

// int c = (n & (1 << idx)) > 0 ? 1 : 0;
// if (trie.get(cur).children[c] == -1) {
// int nex = init();
// trie.get(cur).children[c] = nex;
// }

// int nex = trie.get(cur).children[c];
// add(n, idx - 1, nex);
// }

// void add(int n) {
// add(n, 30, root);
// }

// int search(int n, int idx, int cur, int val) {
// if (idx == -1) {
// return val;
// }

// int c = (n & (1 << idx)) > 0 ? 1 : 0;
// c = 1 - c;
// if (trie.get(cur).children[c] == -1) {
// c = 1 - c;
// }
// val += (c << idx);

// int nex = trie.get(cur).children[c];
// return search(n, idx - 1, nex, val);
// }

// int search(int n) {
// return search(n, 30, root, 0);
// }

// }

// class baek__13504 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int tc = Integer.parseInt(br.readLine());

// StringBuilder sb = new StringBuilder();
// while (tc-- > 0) {
// int n = Integer.parseInt(br.readLine());
// String[] temp = br.readLine().split(" ");
// Trie trie = new Trie();
// int ans = 0;
// int now = 0;
// trie.add(0);
// for (int i = 0; i < n; i++) {
// int num = Integer.parseInt(temp[i]);
// now ^= num;
// trie.add(now);
// ans = Math.max(ans, trie.search(now) ^ now);
// }
// sb.append(ans + "\n");
// }

// System.out.print(sb);

// }
// }
