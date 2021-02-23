import java.io.*;
import java.util.*;

class baek__11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int[][] sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            sum[i][0] = map[i][0];
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + map[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            temp = br.readLine().split(" ");
            int s = 0;

            int x1 = Integer.parseInt(temp[0]);
            x1 -= 1;
            int y1 = Integer.parseInt(temp[1]);
            y1 -= 1;
            int x2 = Integer.parseInt(temp[2]);
            x2 -= 1;
            int y2 = Integer.parseInt(temp[3]);
            y2 -= 1;

            for (int i = x1; i <= x2; i++) {
                s += y1 - 1 == -1 ? sum[i][y2] : sum[i][y2] - sum[i][y1 - 1];
            }
            sb.append(s + " \n");
        }

        System.out.print(sb);

    }
}
