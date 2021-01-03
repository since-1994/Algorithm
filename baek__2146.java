import java.io.*;
import java.util.*;

class baek__2146 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] color = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int idx = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (color[i][j] == 0 && map[i][j] == 1) {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    q.add(j);
                    color[i][j] = idx++;
                    while (!q.isEmpty()) {
                        int x = q.poll();
                        int y = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                                continue;
                            if (map[nx][ny] != 1)
                                continue;
                            if (color[nx][ny] != 0)
                                continue;
                            color[nx][ny] = color[x][y];
                            q.add(nx);
                            q.add(ny);
                        }
                    }
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = -1;
                if (map[i][j] == 1) {
                    q.add(i);
                    q.add(j);
                    dist[i][j] = 0;
                }
            }
        }

        int shortest = n * n;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            int colour = color[x][y];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (color[nx][ny] != 0) {
                    if (color[nx][ny] != colour) {
                        shortest = Math.min(shortest, dist[nx][ny] + dist[x][y]);
                    }
                    continue;
                }
                color[nx][ny] = colour;
                dist[nx][ny] = dist[x][y] + 1;
                q.add(nx);
                q.add(ny);
            }
        }

        System.out.print(shortest);
    }
}