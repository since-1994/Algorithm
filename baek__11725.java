import java.io.*;
import java.util.*;

class baek__11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n - 1; i++) {
            String[] temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);

            list[u].add(v);
            list[v].add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parent[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nex : list[cur]) {
                if (parent[nex] == -1) {
                    parent[nex] = cur;
                    q.add(nex);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}