// import java.io.*;
// import java.util.*;

// class Node {
// int children[];
// boolean valid;

// Node() {
// children = new int[26];
// Arrays.fill(children, -1);
// valid = false;
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
// trie.get(cur).valid = true;
// return;
// }

// int c = s.charAt(idx) - 'a';
// if (trie.get(cur).children[c] == -1) {
// Node x = new Node();
// trie.add(x);
// trie.get(cur).children[c] = trie.size() - 1;
// }

// int next = trie.get(cur).children[c];
// add(s, idx + 1, next);
// }

// void add(String s) {
// add(s, 0, root);
// }

// boolean search(String s, int idx, int cur) {
// if (idx == s.length()) {
// return trie.get(cur).valid;
// }

// int c = s.charAt(idx) - 'a';
// if (trie.get(cur).children[c] == -1) {
// return false;
// }

// int next = trie.get(cur).children[c];
// return search(s, idx + 1, next);
// }

// boolean search(String s) {
// return search(s, 0, root);
// }
// }

// class baek__14425 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// Trie trie = new Trie();

// for (int i = 0; i < n; i++) {
// trie.add(br.readLine());
// }
// int cnt = 0;
// for (int i = 0; i < m; i++) {
// cnt = trie.search(br.readLine()) ? cnt + 1 : cnt;
// }

// System.out.print(cnt);
// }
// }
