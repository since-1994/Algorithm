import java.io.*;
import java.util.*;

class baek__17085 {

    static int n;
    static int m;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static char[][] map;

    static void refresh() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '*')
                    map[i][j] = '#';
            }
        }
    }

    static boolean ok(int i1, int j1, int s1, int i2, int j2, int s2) {
        if (map[i1][j1] != '#')
            return false;

        map[i1][j1] = '*';

        for (int s = 1; s <= s1; s++) {
            for (int k = 0; k < 4; k++) {
                int nx = i1 + dx[k] * s;
                int ny = j1 + dy[k] * s;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    refresh();
                    return false;
                }
                if (map[nx][ny] == '#') {
                    map[nx][ny] = '*';
                } else {
                    refresh();
                    return false;
                }
            }
        }

        if (map[i2][j2] != '#') {
            refresh();
            return false;
        }

        for (int s = 1; s <= s2; s++) {
            for (int k = 0; k < 4; k++) {
                int nx = i2 + dx[k] * s;
                int ny = j2 + dy[k] * s;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    refresh();
                    return false;
                }
                if (map[nx][ny] != '#') {
                    refresh();
                    return false;
                }
            }
        }
        refresh();
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int ans = 0;

        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int s1 = 0; s1 < Math.min(n, m); s1++) {
                    for (int i2 = 0; i2 < n; i2++) {
                        for (int j2 = 0; j2 < m; j2++) {
                            for (int s2 = 0; s2 < Math.min(n, m); s2++) {
                                if (ok(i1, j1, s1, i2, j2, s2)) {
                                    ans = Math.max(ans, (4 * s1 + 1) * (s2 * 4 + 1));
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.print(ans);
    }
}