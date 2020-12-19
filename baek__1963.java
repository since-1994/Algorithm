import java.io.*;
import java.util.*;

class baek__1963 {

    static int getNext(int now, int idx, int num) {
        if (idx == 0 && num == 0) {
            return -1;
        }

        String s = Integer.toString(now);
        StringBuilder sb = new StringBuilder(s);

        sb.setCharAt(idx, (char) (num + '0'));
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[10000];
        Arrays.fill(prime, true);

        for (int i = 2; i < 10000; i++) {
            if (prime[i] == true) {
                for (int j = i + i; j < 10000; j += i) {
                    prime[j] = false;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String[] temp = br.readLine().split(" ");

            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);

            int[] dist = new int[10000];
            Arrays.fill(dist, -1);

            Queue<Integer> q = new LinkedList<>();
            q.add(from);
            dist[from] = 0;

            while (!q.isEmpty()) {
                int now = q.poll();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 10; j++) {
                        int next = getNext(now, i, j);
                        if (next != -1 && prime[next] && dist[next] == -1) {
                            q.add(next);
                            dist[next] = dist[now] + 1;
                        }
                    }
                }
            }
            sb.append(dist[to] == -1 ? "Impossible" : dist[to]);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}