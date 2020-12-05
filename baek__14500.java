import java.io.*;
import java.util.*;

class baek__14500 {
    static int n;
    static int m;
    static boolean[][] check;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        check = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                check[i][j] = false;
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = true;
                answer = Math.max(answer, go(i, j, map[i][j], 1));
                answer = Math.max(answer, calc(i, j));
            }
        }

        System.out.print(answer);
    }

    static int calc(int x, int y) {
        int[][][] peace = { //
                { { 0, 0 }, { -1, 0 }, { -1, -1 }, { -1, 1 } }, //
                { { 0, 0 }, { 0, -1 }, { -1, -1 }, { 1, -1 } }, //
                { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, -1 } }, //
                { { 0, 0 }, { 1, 0 }, { 1, -1 }, { 1, 1 } }//
        };

        int returnValue = 0;

        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x + peace[i][j][0];
                int ny = y + peace[i][j][1];
                if (nx >= 0 && nx < n && ny < m && ny >= 0) {
                    sum += map[nx][ny];
                } else {
                    sum = 0;
                    break;
                }
            }
            returnValue = Math.max(returnValue, sum);
        }

        return returnValue;

    }

    static int go(int x, int y, int sum, int cnt) {
        if (cnt == 4) {
            return sum;
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        int returnValue = 0;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < n && ny < m && ny >= 0 && check[nx][ny] == false) {
                check[nx][ny] = true;
                returnValue = Math.max(returnValue, go(nx, ny, sum + map[nx][ny], cnt + 1));
                check[nx][ny] = false;
            }
        }

        return returnValue;
    }
}
