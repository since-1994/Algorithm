import java.io.*;
import java.util.*;

class baek__1106 {
    static int n;
    static int[] cost;
    static int[] customers;
    static int[] d = new int[1001];

    static int go(int u) {
        if (u <= 0)
            return 0;

        if (d[u] != -1)
            return d[u];

        d[u] = 100001;
        for (int i = 0; i < n; i++) {
            d[u] = Math.min(d[u], go(u - customers[i]) + cost[i]);
        }

        return d[u];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int c = Integer.parseInt(temp[0]);
        n = Integer.parseInt(temp[1]);

        cost = new int[n];
        customers = new int[n];

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            cost[i] = Integer.parseInt(temp[0]);
            customers[i] = Integer.parseInt(temp[1]);
        }

        Arrays.fill(d, -1);
        System.out.print(go(c));
    }
}
