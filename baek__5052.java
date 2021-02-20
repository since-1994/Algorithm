import java.io.*;
import java.util.*;

class Node {
    int children[];
    boolean valid;

    Node() {
        children = new int[10];
        Arrays.fill(children, -1);
        valid = false;
    }
}

class Trie {

    ArrayList<Node> trie;
    int root;

    int init() {
        Node x = new Node();
        trie.add(x);
        return trie.size() - 1;
    }

    Trie() {
        trie = new ArrayList<>();
        root = init();
    }

    void add(String s, int idx, int cur) {
        if (idx == s.length()) {
            trie.get(cur).valid = true;
            return;
        }

        int c = s.charAt(idx) - '0';
        if (trie.get(cur).children[c] == -1) {
            Node x = new Node();
            trie.add(x);
            trie.get(cur).children[c] = trie.size() - 1;
        }

        int next = trie.get(cur).children[c];
        add(s, idx + 1, next);
    }

    void add(String s) {
        add(s, 0, root);
    }

    boolean search(String s, int idx, int cur) {
        if (idx == s.length()) {
            return true;
        }

        int c = s.charAt(idx) - '0';
        if (trie.get(cur).children[c] == -1) {
            return false;
        }
        int next = trie.get(cur).children[c];
        if (trie.get(next).valid) {
            return true;
        }
        return search(s, idx + 1, next);
    }

    boolean search(String s) {
        return search(s, 0, root);
    }
}

class baek__5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();

            boolean yes = true;

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                if (trie.search(s)) {
                    yes = false;
                }
                trie.add(s);
            }
            if (yes)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.print(sb);
    }
}
