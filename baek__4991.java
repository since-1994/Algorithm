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

class baek__4991 {
    static int w;
    static int h;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    static int[][] bfs(Point start, char[][] map) {
        int[][] dist = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
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

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w)
                    continue;
                if (dist[nx][ny] != -1)
                    continue;
                if (map[nx][ny] == 'x')
                    continue;
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new Point(nx, ny));
            }
        }

        return dist;
    }

    static boolean next_permutation(int[] arr) {
        int n = arr.length;

        int start = -1;

        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                start = i - 1;
                break;
            }
        }

        if (start == -1)
            return false;

        for (int i = n - 1; i > start; i--) {
            if (arr[i] > arr[start]) {
                int temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
                break;
            }
        }

        start++;
        int end = n - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] temp = br.readLine().split(" ");
            w = Integer.parseInt(temp[0]);
            h = Integer.parseInt(temp[1]);

            if (w == 0)
                break;

            char[][] map = new char[h][w];

            ArrayList<Point> trashes = new ArrayList<>();
            Point machine = new Point(-1, -1);

            for (int i = 0; i < h; i++) {
                char[] row = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    map[i][j] = row[j];
                    if (map[i][j] == '*') {
                        trashes.add(new Point(i, j));
                    } else if (map[i][j] == 'o') {
                        machine = new Point(i, j);
                    }
                }
            }

            int[][][] dist = new int[trashes.size()][h][w];
            int[][] machineDist = bfs(machine, map);
            for (int i = 0; i < trashes.size(); i++) {
                dist[i] = bfs(trashes.get(i), map);
            }

            int[] arr = new int[trashes.size()];
            for (int i = 0; i < trashes.size(); i++) {
                arr[i] = i;
            }

            int ans = -1;
            do {
                int x = trashes.get(arr[0]).x;
                int y = trashes.get(arr[0]).y;

                int cnt = machineDist[x][y];
                if (cnt == -1)
                    break;

                boolean possible = true;

                for (int i = 1; i < arr.length; i++) {
                    x = trashes.get(arr[i]).x;
                    y = trashes.get(arr[i]).y;

                    if (dist[arr[i - 1]][x][y] == -1) {
                        possible = false;
                        break;
                    }
                    cnt += dist[arr[i - 1]][x][y];
                }

                if (possible)
                    ans = ans == -1 ? cnt : Math.min(cnt, ans);
            } while (next_permutation(arr));

            sb.append(ans + "\n");
        }
        System.out.print(sb);

    }
}