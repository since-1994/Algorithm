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

// int c = s.charAt(idx) - 'A';
// if (trie.get(cur).children[c] == -1) {
// int nex = init();
// trie.get(cur).children[c] = nex;
// }

// int nex = trie.get(cur).children[c];
// add(s, idx + 1, nex);
// }

// void add(String s) {
// add(s, 0, root);
// }

// Pair search(String s, int idx, int cur) {
// if (idx == s.length()) {
// return new Pair(true, trie.get(cur).valid);
// }

// int c = s.charAt(idx) - 'A';
// if (trie.get(cur).children[c] == -1)
// return new Pair(false, false);

// int nex = trie.get(cur).children[c];
// return search(s, idx + 1, nex);
// }

// Pair search(String s) {
// return search(s, 0, root);
// }
// }

// class Pair {
// boolean prefix;
// boolean valid;

// Pair(boolean prefix, boolean valid) {
// this.prefix = prefix;
// this.valid = valid;
// }
// }

// class customComparator implements Comparator<String> {
// public int compare(String a, String b) {
// if (a.length() < b.length()) {
// return -1;
// } else if (a.length() == b.length()) {
// return -a.compareTo(b);
// }
// return 1;
// }
// }

// class baek__9202 {
// static Trie trie;
// static int[] dx = { -1, 0, 1, 0, 1, 1, -1, -1 };
// static int[] dy = { 0, -1, 0, 1, -1, 1, 1, -1 };
// static HashSet<String> set = new HashSet<>();

// static boolean[][] check = new boolean[4][4];

// static int getPoint(String s) {
// if (s.length() == 8) {
// return 11;
// } else if (s.length() == 7) {
// return 5;
// } else if (s.length() == 6) {
// return 3;
// } else if (s.length() == 5) {
// return 2;
// } else if (s.length() == 4 || s.length() == 3) {
// return 1;
// }
// return 0;
// }

// static void go(int x, int y, String[] map, String cur) {
// Pair pair = trie.search(cur);
// if (pair.prefix) {
// if (pair.valid)
// set.add(cur);
// } else {
// return;
// }

// for (int k = 0; k < 8; k++) {
// int nx = x + dx[k];
// int ny = y + dy[k];
// if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
// continue;
// if (check[nx][ny])
// continue;
// check[nx][ny] = true;
// go(nx, ny, map, cur + map[nx].charAt(ny));
// check[nx][ny] = false;
// }
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// trie = new Trie();
// for (int i = 0; i < n; i++) {
// trie.add(br.readLine());
// }

// br.readLine();
// int m = Integer.parseInt(br.readLine());
// StringBuilder sb = new StringBuilder();
// while (m-- > 0) {
// String[] map = new String[4];
// for (int i = 0; i < 4; i++) {
// map[i] = br.readLine();
// }
// for (int i = 0; i < 4; i++) {
// for (int j = 0; j < 4; j++) {
// check[i][j] = true;
// go(i, j, map, Character.toString(map[i].charAt(j)));
// check[i][j] = false;
// }
// }
// ArrayList<String> list = new ArrayList(set);
// set.clear();
// long points = 0;
// for (int i = 0; i < list.size(); i++) {
// String s = list.get(i);
// points += getPoint(s);
// }
// Collections.sort(list, new customComparator());
// sb.append(points + " " + list.get(list.size() - 1) + " " + list.size() +
// "\n");
// if (m != 0) {
// br.readLine();
// }
// }

// System.out.print(sb);

// }
// }
