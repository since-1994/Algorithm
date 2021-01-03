import java.io.*;
import java.util.*;

class baek__16947 {
    static int n;
    static int start = -1;
    static int end = -1;
    static int[] back;
    static ArrayList<Integer>[] list;
    static boolean[] check;
    static Queue<Integer> q = new LinkedList<>();
    static int[] dist;

    static boolean go(int now, int before) {
        if (check[now]) {
            start = before;
            end = now;
            return true;
        }

        check[now] = true;
        back[now] = before;

        for (int nex : list[now]) {
            if (nex == before)
                continue;
            if (go(nex, now)) {
                return true;
            }
        }

        return false;
    }

    static void findCycle(int now) {
        q.add(now);
        dist[now] = 0;
        if (back[now] == end) {
            q.add(back[now]);
            dist[back[now]] = 0;
            return;
        }
        findCycle(back[now]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        check = new boolean[n + 1];
        back = new int[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        String[] temp;

        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);

            list[from].add(to);
            list[to].add(from);
        }

        go(1, -1);
        findCycle(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nex : list[cur]) {
                if (dist[nex] == -1) {
                    dist[nex] = dist[cur] + 1;
                    q.add(nex);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.print(dist[i] + " ");
        }

    }
}