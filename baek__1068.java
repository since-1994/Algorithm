import java.io.*;
import java.util.*;

class baek__1068 {
    static ArrayList<Integer>[] list;
    static int removed;

    static int dfs(int now, int before) {
        if (now == removed)
            return 0;

        if (list[now].size() == 0) {
            return 1;
        }

        int cnt = 0;

        for (int next : list[now]) {
            if (next == before)
                continue;
            cnt += dfs(next, now);
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int root = -1;
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        String[] temp = br.readLine().split(" ");

        removed = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(temp[i]) == -1) {
                root = i;
                continue;
            }
            if (i == removed)
                continue;
            list[Integer.parseInt(temp[i])].add(i);
        }

        System.out.print(dfs(root, root));
    }
}
