import java.io.*;
import java.util.*;

class baek__1956 {
    static int MAX = 4000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int v = Integer.parseInt(temp[0]);
        int e = Integer.parseInt(temp[1]);

        int[][] dist = new int[v + 1][v + 1];

        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                dist[i][j] = MAX;
            }
        }

        for (int i = 0; i < e; i++) {
            temp = br.readLine().split(" ");

            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);

            dist[a][b] = Math.min(dist[a][b], c);
        }

        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    if (i == j)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int answer = -1;

        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (i == j)
                    continue;
                if (dist[i][j] == MAX || dist[j][i] == MAX)
                    continue;
                int d = dist[i][j] + dist[j][i];
                answer = answer == -1 ? d : Math.min(answer, d);
            }
        }

        System.out.print(answer);
    }
}
