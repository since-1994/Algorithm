import java.io.*;
import java.util.*;

class baek__2447 {
    static char[][] map;
    static int[] dx = { 0, 0, 0, 1, 1, 2, 2, 2 };
    static int[] dy = { 0, 1, 2, 0, 2, 0, 1, 2 };

    static void go(int x, int y, int len) {
        if (len == 1) {
            map[x][y] = '*';
            return;
        }
        int nLen = len / 3;

        for (int k = 0; k < 8; k++) {
            go(x + dx[k] * nLen, y + dy[k] * nLen, nLen);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = ' ';
            }
        }

        go(0, 0, n);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}