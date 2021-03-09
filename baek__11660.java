import java.io.*;
import java.util.*;

class baek__11660 {
    static int n;
    static int[][] map;
    static int[][] d;

    static int go(int r, int c) {
        if (r < 0 || c < 0)
            return 0;

        if (d[r][c] != -1)
            return d[r][c];

        if (c - 1 < 0) {
            d[r][c] = map[r][c];
        } else {
            d[r][c] = go(r, c - 1) + map[r][c];
        }

        return d[r][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        map = new int[n][n];
        d = new int[n][n];

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                d[i][j] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            temp = br.readLine().split(" ");

            int sX = Integer.parseInt(temp[0]);
            sX -= 1;
            int sY = Integer.parseInt(temp[1]);
            sY -= 1;

            int eX = Integer.parseInt(temp[2]);
            eX -= 1;
            int eY = Integer.parseInt(temp[3]);
            eY -= 1;

            int sum = 0;
            for (int i = sX; i <= eX; i++) {
                sum += go(i, eY) - go(i, sY - 1);
            }

            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }
}
