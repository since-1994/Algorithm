import java.io.*;
import java.util.*;

class baek__1987 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] check;
    static boolean[] alphabet = new boolean[256];

    static int go(int x, int y, int cnt) {
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        int returnValue = 0;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (check[nx][ny] == false && alphabet[map[nx][ny]] == false) {
                    check[nx][ny] = true;
                    alphabet[map[nx][ny]] = true;
                    returnValue = Math.max(returnValue, go(nx, ny, cnt + 1));
                    check[nx][ny] = false;
                    alphabet[map[nx][ny]] = false;
                } else {
                    returnValue = Math.max(returnValue, cnt);
                }
            }
        }

        return returnValue;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        map = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j];
            }
        }
        check[0][0] = true;
        alphabet[map[0][0]] = true;
        System.out.print(go(0, 0, 1));
    }
}