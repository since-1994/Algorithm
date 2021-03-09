import java.io.*;
import java.util.*;

class baek__13302 {
    static int MAX = 100;
    static boolean[] isBusy = new boolean[MAX + 1];
    static int[][] d = new int[MAX + 1][MAX + 1];

    static int go(int day, int coupon) {
        if (coupon < 0 || coupon >= 100) {
            return MAX * 10000;
        }
        if (day <= 0) {
            if (day == 0 && coupon == 0) {
                return 0;
            }
            return MAX * 10000;
        }
        if (d[day][coupon] != -1)
            return d[day][coupon];

        d[day][coupon] = MAX * 10000;
        if (isBusy[day])
            d[day][coupon] = go(day - 1, coupon);

        d[day][coupon] = Math.min(d[day][coupon], go(day - 1, coupon + 3));
        d[day][coupon] = Math.min(d[day][coupon], go(day - 1, coupon) + 10000);
        d[day][coupon] = Math.min(d[day][coupon], go(day - 3, coupon - 1) + 25000);
        d[day][coupon] = Math.min(d[day][coupon], go(day - 5, coupon - 2) + 37000);

        return d[day][coupon];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        for (int i = 0; i < MAX + 1; i++) {
            for (int j = 0; j < MAX + 1; j++) {
                d[i][j] = -1;
            }
        }
        if (m > 0)
            temp = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            isBusy[Integer.parseInt(temp[i])] = true;
        }

        int answer = 10000 * MAX;
        for (int i = 0; i < MAX + 1; i++) {
            answer = Math.min(answer, go(n, i));
        }

        System.out.print(answer);
    }
}
