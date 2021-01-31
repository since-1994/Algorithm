import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class baek__17086 {
    static int n;
    static int m;
    static int[][] map;
    static ArrayList<Point> sharks;
    static int[] dx = { -1, 0, 1, 0, -1, -1, 1, 1 };
    static int[] dy = { 0, -1, 0, 1, -1, 1, -1, 1 };

    static int bfs(Point start) {
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        dist[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (dist[nx][ny] != -1)
                    continue;
                q.add(new Point(nx, ny));
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

        int ans = dist[sharks.get(0).x][sharks.get(0).y];

        for (Point shark : sharks) {
            ans = Math.min(ans, dist[shark.x][shark.y]);
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        map = new int[n][m];
        sharks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                if (map[i][j] == 1) {
                    sharks.add(new Point(i, j));
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    ans = Math.max(ans, bfs(new Point(i, j)));
                }
            }
        }

        System.out.print(ans);
    }
}