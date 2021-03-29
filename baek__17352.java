import java.io.*;
import java.util.*;

class baek__17352 {
    static void dfs(int now, ArrayList<Integer>[] list, boolean[] visited) {
        visited[now] = true;

        for (int next : list[now]) {
            if (visited[next])
                continue;
            dfs(next, list, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 2; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            list[a].add(b);
            list[b].add(a);
        }

        boolean[] visited = new boolean[n + 1];

        if (list[1].size() != -1) {
            dfs(1, list, visited);
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    System.out.print(1 + " " + i);
                    return;
                }
            }
        } else {
            System.out.print(1 + " " + 2);
        }
    }
}
