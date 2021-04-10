import java.io.*;
import java.util.*;

class baek__1238 {
    static int MAX = 200001;

    static void floyd(int n, int k, int[][] dist) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j)
                    continue;
                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int party_place = Integer.parseInt(temp[2]);

        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dist[i][j] = MAX;
            }
        }

        while (m-- > 0) {
            temp = br.readLine().split(" ");
            int s = Integer.parseInt(temp[0]);
            int e = Integer.parseInt(temp[1]);
            int t = Integer.parseInt(temp[2]);

            dist[s][e] = Math.min(dist[s][e], t);
        }

        for (int k = 1; k < n + 1; k++) {
            floyd(n, k, dist);
        }

        int longest_time = -1;

        for (int i = 1; i < n + 1; i++) {
            if (i == party_place)
                continue;

            int tot = dist[i][party_place] + dist[party_place][i];

            longest_time = longest_time == -1 ? tot : Math.max(longest_time, tot);
        }

        System.out.print(longest_time);
    }
}
