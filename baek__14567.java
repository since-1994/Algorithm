import java.io.*;
import java.util.*;

class baek__14567 {
    static int[] d;

    static int go(int now, ArrayList<Integer>[] list) {
        if (list[now].size() == 0) {
            return 1;
        }

        if (d[now] != -1)
            return d[now];

        d[now] = 1;

        for (int next : list[now]) {
            d[now] = Math.max(d[now], go(next, list) + 1);
        }

        return d[now];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        ArrayList<Integer>[] list = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        ArrayList<Integer> candidates = new ArrayList<>();

        while (m-- > 0) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            candidates.add(a);
            list[b].add(a);
        }

        StringBuilder sb = new StringBuilder();

        d = new int[n + 1];
        Arrays.fill(d, -1);

        for (int i = 1; i < n + 1; i++) {
            sb.append(go(i, list) + " ");
        }

        System.out.print(sb);
    }
}
