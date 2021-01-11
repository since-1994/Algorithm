import java.io.*;
import java.util.*;

class baek__4902 {

    static int n;
    static int[][] sum = new int[400][400 * 2 + 1];

    static int start(int h, int y) {

        int x = h;
        int leftY = y;
        int rightY = y;

        int ans = 0;

        int tot = sum[x][y];
        if (y >= 1)
            tot -= sum[x][y - 1];
        ans = tot;
        while (true) {
            if (y % 2 != 0) {
                leftY -= 2;
                x -= 1;
            } else {
                rightY += 2;
                x += 1;
            }
            if (leftY < 0 || rightY >= 2 * x + 1 || x >= n || x < 0)
                break;

            tot += sum[x][rightY];
            if (leftY > 0) {
                tot -= sum[x][leftY - 1];
            }
            ans = Math.max(tot, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        int idx = 1;

        while (true) {
            n = sc.nextInt();
            if (n == 0)
                break;
            int[][] map = new int[n][2 * n - 1];

            for (int i = 1; i <= n; i++) {
                int cur = 0;
                for (int j = 0; j < 2 * i - 1; j++) {
                    map[i - 1][j] = sc.nextInt();
                    cur += map[i - 1][j];
                    sum[i - 1][j] = cur;
                }
            }

            int ans = -1000 * (n * n);

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < 2 * i + 1; j++) {
                    ans = Math.max(ans, start(i - 1, j));
                }
            }

            sb.append(idx++);
            sb.append(". ");
            sb.append(ans);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}