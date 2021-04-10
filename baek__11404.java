import java.io.*;
import java.util.*;

class baek__11404 {
    static int MAX = 10000001;

    static class Node {
        int x;
        int cost;

        Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Node>[] list = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dist[i][j] = MAX;
            }
        }

        String[] temp;
        while (m-- > 0) {
            temp = br.readLine().split(" ");

            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            int cost = Integer.parseInt(temp[2]);

            if (dist[start][end] > cost)
                dist[start][end] = cost;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i == j)
                        continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                sb.append(dist[i][j] == MAX ? 0 : dist[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
