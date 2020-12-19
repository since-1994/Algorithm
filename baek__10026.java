import java.io.*;
import java.util.*;

class baek__10026 {

    static int n;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static char[][] map;

    static boolean can(boolean disable, int x, int y, int nx, int ny) {
        if (map[x][y] == map[nx][ny])
            return true;
        else if (disable) {
            if (map[x][y] == 'R' && map[nx][ny] == 'G')
                return true;
            else if (map[x][y] == 'G' && map[nx][ny] == 'R')
                return true;
        }
        return false;
    }

    static int go(boolean disable) {

        boolean[][] check = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j])
                    continue;
                q.add(i);
                q.add(j);
                check[i][j] = true;
                cnt++;
                while (!q.isEmpty()) {
                    int x = q.poll();
                    int y = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                            continue;
                        if (check[nx][ny])
                            continue;
                        if (can(disable, x, y, nx, ny)) {
                            q.add(nx);
                            q.add(ny);
                            check[nx][ny] = true;
                        }
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = row[j];
            }
        }

        System.out.print(go(false) + " " + go(true));

    }
}