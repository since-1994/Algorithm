import java.io.*;
import java.util.*;

class baek__17616 {
    static ArrayList<Integer>[] list;
    static ArrayList<Integer>[] list1;

    static boolean[] check = new boolean[100001];
    static boolean[] check1 = new boolean[100001];

    static int[] sum = new int[100001];
    static int[] sum1 = new int[100001];

    static void dfs(int now) {
        sum[now] += 1;
        check[now] = true;

        for (int next : list[now]) {
            if (check[next])
                continue;
            dfs(next);
            sum[now] += sum[next];
        }
    }

    static void dfs1(int now) {
        sum1[now] += 1;
        check1[now] = true;

        for (int next : list1[now]) {
            if (check1[next])
                continue;
            dfs1(next);
            sum1[now] += sum1[next];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int x = Integer.parseInt(temp[2]);

        list = new ArrayList[n + 1];
        list1 = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
            list1[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);

            list[u].add(v);
            list1[v].add(u);
        }

        dfs(x);
        dfs1(x);

        System.out.print(sum1[x] + " " + (n - sum[x] + 1));
        // System.out.print(sum1[4]);
    }
}
