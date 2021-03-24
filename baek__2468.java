import java.io.*;
import java.util.*;

class baek__2468 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    static void dfs(int x, int y, boolean[][] visited, int[][] map, int n, int limit) {
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            if (visited[nx][ny])
                continue;

            if (map[nx][ny] <= limit)
                continue;

            dfs(nx, ny, visited, map, n, limit);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int answer = 0;

        for (int k = 0; k <= 100; k++) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                }
            }

            int area = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > k && !visited[i][j]) {
                        area++;
                        dfs(i, j, visited, map, n, k);
                    }
                }
            }

            answer = Math.max(answer, area);
        }

        System.out.print(answer);
    }
}
