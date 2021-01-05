import java.io.*;
import java.util.*;

class baek__13549 {

    static int MAX = 200000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.addLast(n);
        dist[n] = 0;

        while (!d.isEmpty()) {
            int cur = d.poll();

            for (int nex : new int[] { cur * 2, cur + 1, cur - 1 }) {
                if (nex < 0 || nex > MAX)
                    continue;
                if (dist[nex] != -1)
                    continue;
                if (nex == cur * 2) {
                    d.addFirst(nex);
                    dist[nex] = dist[cur];
                } else {
                    d.addLast(nex);
                    dist[nex] = dist[cur] + 1;
                }
            }
        }

        System.out.print(dist[k]);
    }
}