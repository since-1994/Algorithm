import java.io.*;
import java.util.*;

class baek__9944 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] check;

    static int go(int x, int y, int remain, int move_cnt) {
        if (remain == 0) {
            return move_cnt;
        }

        int ans = -1;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            while (0 <= nx && nx < n && ny >= 0 && ny < m && check[nx][ny] == false && map[nx][ny] == '.') {
                check[nx][ny] = true;
                remain -= 1;
                nx += dx[k];
                ny += dy[k];
            }
            nx -= dx[k];
            ny -= dy[k];
            if (nx != x || ny != y) {
                int result = go(nx, ny, remain, move_cnt + 1);
                if (result != -1) {
                    ans = ans == -1 ? result : Math.min(result, ans);
                }
            }
            while (nx != x || ny != y) {
                check[nx][ny] = false;
                remain += 1;
                nx -= dx[k];
                ny -= dy[k];
            }

        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int idx = 1;
        while (sc.hasNextLine()) {
            n = sc.nextInt();
            m = sc.nextInt();
            check = new boolean[n][m];

            map = new char[n][m];
            int remain = 0;

            for (int i = 0; i < n; i++) {
                map[i] = sc.next().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '.') {
                        remain += 1;
                    }
                }
            }
            int ans = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '.') {
                        check[i][j] = true;
                        int result = go(i, j, remain - 1, 0);
                        check[i][j] = false;
                        if (result != -1) {
                            ans = ans == -1 ? result : Math.min(result, ans);
                        }
                    }
                }
            }
            System.out.printf("Case %d: %d\n", idx++, ans);
        }

    }
}