import java.io.*;
import java.util.*;

class Node {
    int[] children;
    boolean valid;

    Node() {
        children = new int[2];
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
            int nex = init();
            trie.get(cur).children[c] = nex;
        }

        int nex = trie.get(cur).children[c];
        add(s, idx + 1, nex);
    }

    void add(String s) {
        add(s, 0, root);
    }

    int search(String s, int idx, int cur, int ans) {
        if (idx == s.length()) {
            return ans;
        }

        int c = 1 - (s.charAt(idx) - '0');
        if (trie.get(cur).children[c] == -1) {
            c = 1 - c;
        } else {
            ans += (1 << s.length() - 1 - idx);
        }
        int nex = trie.get(cur).children[c];
        return search(s, idx + 1, nex, ans);
    }

    int search(String s) {
        return search(s, 0, root, 0);// 0번째에 0이라고 생각하자.
    }
}

class baek__13505 {

    static String getBinary(int n) {
        String s = "";
        while (n >= 2) {
            s = (n % 2) + s;
            n /= 2;
        }
        s = n + s;
        while (s.length() < 31) {
            s = '0' + s;
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        int[] nums = new int[n];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
            String s = getBinary(nums[i]);
            trie.add(s);
        }

        // System.out.println(getBinary(2));
        // System.out.print(getBinary(trie.search(getBinary(2))));

        int answer = -1;
        for (int i = 0; i < n; i++) {
            String s = getBinary(nums[i]);
            int comp = trie.search(s);
            answer = answer == -1 ? comp : Math.max(answer, comp);
        }

        System.out.print(answer);

    }
}
