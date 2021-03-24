// import java.io.*;
// import java.util.*;

// class Node {
// int[] children;
// boolean prime;

// Node() {
// this.prime = false;
// this.children = new int[10];
// Arrays.fill(children, -1);
// }
// }

// class Trie {
// int root;
// ArrayList<Node> trie;

// int init() {
// Node node = new Node();
// trie.add(node);
// return trie.size() - 1;
// }

// Trie() {
// trie = new ArrayList<>();
// root = init();
// }

// void add(String s, int idx, int cur) {
// if (idx == s.length()) {
// trie.get(cur).prime = true;
// return;
// }

// int c = s.charAt(idx) - '0';
// if (trie.get(cur).children[c] == -1) {
// int next = init();
// trie.get(cur).children[c] = next;
// }

// int next = trie.get(cur).children[c];
// add(s, idx + 1, next);
// }

// void add(String s) {
// add(s, 0, root);
// }

// void search(int n, int count, String value, int cur) {
// if (value.length() != 0 && !trie.get(cur).prime)
// return;

// if (count == n) {
// System.out.println(value);
// return;
// }

// for (int i = 0; i < 10; i++) {
// int next = trie.get(cur).children[i];
// if (next != -1)
// search(n, count + 1, value + i, next);
// }
// }

// void search(int n) {
// search(n, 0, "", root);
// }
// }

// class baek__2023 {
// static Trie trie = new Trie();

// static boolean isPrime(int n) {
// for (int i = 2; i * i <= n; i++) {
// if (n % i == 0) {
// return false;
// }
// }

// return true;
// }

// static void go(int n, int len, int limit) {
// trie.add(Integer.toString(n));

// if (len == limit) {
// return;
// }

// for (int i = 0; i < 10; i++) {
// if (isPrime(n * 10 + i)) {
// go(n * 10 + i, len + 1, limit);
// }
// }
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// int n = Integer.parseInt(br.readLine());

// go(2, 1, n);
// go(3, 1, n);
// go(5, 1, n);
// go(7, 1, n);

// trie.search(n);
// }
// }
