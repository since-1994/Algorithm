import java.io.*;
import java.util.*;

class baek__12852 {
    static int[] before;

    static void print(int n) {
        if (before[n] == n) {
            System.out.print(n + " ");
            return;
        }
        print(before[n]);
        System.out.print(n + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        before = new int[n + 1];
        Arrays.fill(d, -1);
        for (int i = 0; i < n + 1; i++) {
            before[i] = i;
        }

        Queue<Integer> q = new LinkedList<>();
        d[n] = 0;
        q.add(n);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now <= 1)
                continue;

            int nex = now - 1;
            if (d[nex] == -1) {
                q.add(nex);
                d[nex] = d[now] + 1;
                before[nex] = now;
            }

            if (now % 2 == 0) {
                nex = now / 2;
                if (d[nex] == -1) {
                    q.add(nex);
                    d[nex] = d[now] + 1;
                    before[nex] = now;
                }
            }

            if (now % 3 == 0) {
                nex = now / 3;
                if (d[nex] == -1) {
                    q.add(nex);
                    d[nex] = d[now] + 1;
                    before[nex] = now;
                }
            }
        }

        System.out.println(d[1]);
        print(1);
    }
}
