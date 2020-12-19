import java.io.*;
import java.util.*;

class baek__6087 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[1]);
        int m = Integer.parseInt(temp[0]);

        char[][] map = new char[n][m];
        int[][] dist = new int[n][m];

        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
                map[i][j] = row[j];
                if (map[i][j] == 'C') {
                    if (startX == -1) {
                        startX = i;
                        startY = j;
                    } else {
                        endX = i;
                        endY = j;
                    }
                    map[i][j] = '.';
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(startX);
        q.add(startY);
        dist[startX][startY] = 0;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            // System.out.println(x + " " + y);
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '.') {
                    if (dist[nx][ny] == -1) {
                        q.add(nx);
                        q.add(ny);
                        dist[nx][ny] = dist[x][y] + 1;
                        if (nx == endX && ny == endY) {
                            System.out.print(dist[endX][endY] - 1);
                            return;
                        }
                    }
                    nx += dx[k];
                    ny += dy[k];
                }
            }
        }
    }
}