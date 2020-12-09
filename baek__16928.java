import java.io.*;
import java.util.*;

class baek__16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]);

        int[] dist = new int[101];
        Arrays.fill(dist, -1);

        int[] chance = new int[101];
        for (int i = 1; i <= 100; i++) {
            chance[i] = i;
        }

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");

            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);
            chance[from] = to;
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= 6; i++) {
                int nex = cur + i;
                if (nex > 100)
                    continue;
                nex = chance[nex];
                if (dist[nex] != -1)
                    continue;
                dist[nex] = dist[cur] + 1;
                q.add(nex);
            }
        }

        System.out.print(dist[100]);
    }
}