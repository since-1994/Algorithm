import java.io.*;
import java.util.*;

class baek__1080 {

    static void flip(int[][] a, int x, int y) {
        for (int i = x; i <= x + 2; i++) {
            for (int j = y; j <= y + 2; j++) {
                a[i][j] = 1 - a[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                a[i][j] = row[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                b[i][j] = row[j] - '0';
            }
        }
        int answer = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    answer++;
                    flip(a, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    System.out.print(-1);
                    return;
                }
            }
        }

        System.out.print(answer);

    }
}