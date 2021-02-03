import java.io.*;
import java.util.*;

class baek__2606 {
    static int[] parent;

    static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        parent[n] = find(parent[n]);
        return parent[n];
    }

    static void union(int i, int j) {
        i = find(i);
        j = find(j);

        parent[j] = i;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;// 초기화
        }

        String[] temp;
        while (m-- > 0) {
            temp = br.readLine().split(" ");
            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);

            union(from, to);
        }

        int target = find(1);

        int cnt = 0;
        for (int i = 2; i < n + 1; i++) {
            if (find(i) == target)
                cnt++;
        }

        System.out.print(cnt);
    }
}