import java.io.*;
import java.util.*;

class baek__1717 {
    static int[] parent;
    static int[] rank;

    static int find(int n) {
        if (n == parent[n]) {
            return n;
        }
        return parent[n] = find(parent[n]);// 경로압축
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return;
        if (rank[x] < rank[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        if (rank[x] == rank[y]) {
            rank[x] = rank[y] + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            temp = br.readLine().split(" ");
            int op = Integer.parseInt(temp[0]);
            int x = Integer.parseInt(temp[1]);
            int y = Integer.parseInt(temp[2]);

            if (op == 1) {
                if (find(x) == find(y))
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            } else {
                union(x, y);
            }
        }

        System.out.print(sb);
    }
}
