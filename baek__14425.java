// import java.io.*;
// import java.util.*;

// class Node {
// int[] children;
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
// Node node = new Node();
// trie.add(node);
// return trie.size() - 1;
// }

// Trie() {
// trie = new ArrayList<>();
// root = init();
// }

// void add(int node, String s, int index) {
// if (index == s.length()) {
// trie.get(node).valid = true;
// return;
// }
// int c = s.charAt(index) - 'a';
// if (trie.get(node).children[c] == -1) {
// int next = init();
// trie.get(node).children[c] = next;
// }
// int child = trie.get(node).children[c];
// add(child, s, index + 1);
// }

// void add(String s) {
// add(root, s, 0);
// }

// boolean search(int node, String s, int index) {
// if (index == s.length()) {
// return trie.get(node).valid;
// }

// int c = s.charAt(index) - 'a';
// if (trie.get(node).children[c] == -1)
// return false;

// int child = trie.get(node).children[c];
// return search(child, s, index + 1);
// }

// boolean search(String s) {
// return search(root, s, 0);
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

// int answer = 0;
// for (int i = 0; i < m; i++) {
// if (trie.search(br.readLine()))
// answer++;
// }

// System.out.print(answer);
// }
// }
