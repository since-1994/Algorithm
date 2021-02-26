import java.io.*;
import java.util.*;

class baek__14846 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int[][][] count = new int[n][n][11];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = j; l < n; l++) {
                    count[i][l][map[i][j]]++;
                }
            }
        }

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            temp = br.readLine().split(" ");
            int x1 = Integer.parseInt(temp[0]);
            int y1 = Integer.parseInt(temp[1]);
            int x2 = Integer.parseInt(temp[2]);
            int y2 = Integer.parseInt(temp[3]);
            x1--;
            y1--;
            x2--;
            y2--;
            HashSet<Integer> set = new HashSet<>();

            for (int i = x1; i <= x2; i++) {
                for (int j = 1; j <= 10; j++) {
                    if (y1 - 1 < 0) {
                        if (count[i][y2][j] > 0)
                            set.add(j);
                    } else if (count[i][y2][j] - count[i][y1 - 1][j] > 0)
                        set.add(j);
                }
            }
            sb.append(set.size() + "\n");
        }

        System.out.print(sb);
    }
}
