import java.io.*;
import java.util.*;

class baek__12970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        if (m > (n / 2) * (n - (n / 2))) {
            System.out.print(-1);
            return;
        }

        int a = 0;
        int b = 0;

        for (int i = 1; i < n; i++) {
            a = i;
            b = n - i;

            int target = m;
            int[] cnt = new int[b + 1];
            Arrays.fill(cnt, 0);

            for (int j = 0; j < a; j++) {
                int index = Math.min(b, target);
                cnt[index]++;
                target -= index;
            }

            if (target == 0) {
                printCnt(cnt);
                return;
            }
        }
    }

    static void printCnt(int[] cnt) {
        for (int i = cnt.length - 1; i >= 0; i--) {
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print('A');
            }
            if (i != 0)
                System.out.print('B');
        }
    }
}
