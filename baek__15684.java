import java.io.*;
import java.util.*;

class baek__15684 {
    static int n;
    static int h;
    static int[][] map;

    static int start(int y) {
        int x = 0;
        while (x < h) {
            if (map[x][y] == 1) {
                y += 1;
            } else if (map[x][y] == 2) {
                y -= 1;
            }
            x += 1;
        }
        return y;
    }

    static boolean go() {
        for (int i = 0; i < n; i++) {
            if (i != start(i))
                return false;
        }
        return true;
    }

    static void color(int x, int y, boolean ok) {
        if (ok) {
            map[x][y] = 1;
            map[x][y + 1] = 2;
        } else {
            map[x][y] = 0;
            map[x][y + 1] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        h = Integer.parseInt(temp[2]);

        if (m == 0) {
            System.out.print(0);
            return;
        }

        map = new int[h][n];
        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            a -= 1;
            b -= 1;

            map[a][b] = 1;
            map[a][b + 1] = 2;
        }
        int ans = -1;
        if (go()) {
            ans = 0;
        }

        for (int x1 = 0; x1 < h; x1++) {
            for (int y1 = 0; y1 < n - 1; y1++) {
                if (map[x1][y1] != 0 || map[x1][y1 + 1] != 0)
                    continue;
                color(x1, y1, true);
                if (go())
                    ans = ans == -1 ? 1 : Math.min(ans, 1);
                for (int x2 = 0; x2 < h; x2++) {
                    for (int y2 = 0; y2 < n - 1; y2++) {
                        if (map[x2][y2] != 0 || map[x2][y2 + 1] != 0)
                            continue;
                        color(x2, y2, true);
                        if (go())
                            ans = ans == -1 ? 2 : Math.min(ans, 2);
                        for (int x3 = 0; x3 < h; x3++) {
                            for (int y3 = 0; y3 < n - 1; y3++) {
                                if (map[x3][y3] != 0 || map[x3][y3 + 1] != 0)
                                    continue;
                                color(x3, y3, true);
                                if (go())
                                    ans = ans == -1 ? 3 : Math.min(ans, 3);
                                color(x3, y3, false);
                            }
                        }
                        color(x2, y2, false);
                    }
                }
                color(x1, y1, false);
            }
        }

        System.out.print(ans);
    }
}