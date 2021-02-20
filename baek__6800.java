// import java.io.*;
// import java.util.*;

// class Node {
// int children[];
// int c;

// Node() {
// children = new int[2];
// Arrays.fill(children, -1);
// c = -1;
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

// void add(String s, int idx, int cur, char c) {
// if (idx == s.length()) {
// trie.get(cur).c = c - 'A';
// return;
// }

// int child = s.charAt(idx) - '0';
// if (trie.get(cur).children[child] == -1) {
// Node x = new Node();
// trie.add(x);
// trie.get(cur).children[child] = trie.size() - 1;
// }

// int next = trie.get(cur).children[child];
// add(s, idx + 1, next, c);
// }

// void add(String s, char c) {
// add(s, 0, root, c);
// }

// int search(String s, int idx, int cur) {
// if (idx == s.length()) {
// return trie.get(cur).c;
// }

// int c = s.charAt(idx) - '0';
// if (trie.get(cur).children[c] == -1) {
// return -1;
// }

// int next = trie.get(cur).children[c];
// return search(s, idx + 1, next);
// }

// int search(String s) {
// return search(s, 0, root);
// }
// }

// class baek__6800 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());

// Trie trie = new Trie();
// String[] temp;
// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// char c = temp[0].charAt(0);
// String s = temp[1];

// trie.add(s, c);
// }

// String huff = br.readLine();

// String ans = "";
// int start = 0;
// int end = 0;

// while (start < huff.length()) {
// int a = trie.search(huff.substring(start, end + 1));
// if (a == -1) {
// end += 1;
// } else {
// ans += (char) (a + 'A');
// start = end + 1;
// }
// }

// System.out.print(ans);
// }
// }
