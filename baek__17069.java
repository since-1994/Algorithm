import java.io.*;
import java.util.*;

class baek__17069 {
    static long[][][] d = new long[40][40][3];// 0:가로 1:세로 2:대각선
    static int[][] map;
    static int n;

    static boolean ok(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < n)
            return true;
        return false;
    }

    static long go(int x, int y, int dir) {
        if (d[x][y][dir] != -1) {
            return d[x][y][dir];
        }

        if (map[x][y] != 0) {
            return 0;
        }

        d[x][y][dir] = 0;

        if (dir == 2) {
            int fx = x - 1;
            int fy = y - 1;
            int ex = x - 2;
            int ey = y - 2;
            int x1 = x;
            int y1 = y - 1;
            int x2 = x - 1;
            int y2 = y;

            if (ok(ex, ey) && map[ex][ey] == 0 && map[x1][y1] == 0 && map[x2][y2] == 0 && map[fx][fy] == 0) {
                d[x][y][dir] += go(fx, fy, 2);
            }

            ex = x - 2;
            ey = y - 1;
            if (ok(ex, ey) && map[ex][ey] == 0 && map[x1][y1] == 0 && map[x2][y2] == 0 && map[fx][fy] == 0) {
                d[x][y][dir] += go(fx, fy, 1);
            }

            ex = x - 1;
            ey = y - 2;
            if (ok(ex, ey) && map[ex][ey] == 0 && map[x1][y1] == 0 && map[x2][y2] == 0 && map[fx][fy] == 0) {
                d[x][y][dir] += go(fx, fy, 0);
            }
        }

        if (dir == 1) {
            int fx = x - 1;
            int fy = y;
            int ex = x - 2;
            int ey = y - 1;

            if (ok(ex, ey) && map[ex][ey] == 0) {
                d[x][y][dir] += go(fx, fy, 2);
            }

            ex = x - 2;
            ey = y;

            if (ok(ex, ey) && map[ex][ey] == 0) {
                d[x][y][dir] += go(fx, fy, 1);
            }

        }

        if (dir == 0) {

            int fx = x;
            int fy = y - 1;
            int ex = x - 1;
            int ey = y - 2;

            if (ok(ex, ey) && map[ex][ey] == 0) {
                d[x][y][dir] += go(fx, fy, 2);
            }

            ex = x;
            ey = y - 2;

            if (ok(ex, ey) && map[ex][ey] == 0) {
                d[x][y][dir] += go(fx, fy, 0);
            }
        }

        return d[x][y][dir];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                for (int k = 0; k < 3; k++) {
                    d[i][j][k] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        d[0][1][0] = 1;
        System.out.print(go(n - 1, n - 1, 0) + go(n - 1, n - 1, 1) + go(n - 1, n - 1, 2));
    }
}