import java.io.*;
import java.util.*;

class baek__15681 {
    static ArrayList<Integer>[] list;
    static int[] sub = new int[100001];

    static void dfs(int now, int before) {
        sub[now] += 1;
        for (int next : list[now]) {
            if (next == before)
                continue;
            dfs(next, now);
            sub[now] += sub[next];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int r = Integer.parseInt(temp[1]);
        int q = Integer.parseInt(temp[2]);

        list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);

            list[u].add(v);
            list[v].add(u);
        }

        dfs(r, r);

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int qq = Integer.parseInt(br.readLine());
            sb.append(sub[qq] + "\n");
        }

        System.out.print(sb);

    }
}
