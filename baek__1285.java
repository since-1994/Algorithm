import java.io.*;
import java.util.*;

class baek__1285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] now = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (row[j] == 'T')
                    now[i][j] = 1;
                else
                    now[i][j] = 0;
            }
        }

        int answer = -1;

        for (int k = 0; k < (1 << n); k++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int h = 0;
                int t = 0;
                for (int i = 0; i < n; i++) {
                    if (((1 << i) & k) > 0) {
                        if (now[i][j] == 1)
                            h++;
                        else
                            t++;
                    } else {
                        if (now[i][j] == 1)
                            t++;
                        else
                            h++;
                    }
                }
                sum += Math.min(h, t);
            }
            answer = answer == -1 ? sum : Math.min(answer, sum);
        }

        System.out.print(answer);

    }
}