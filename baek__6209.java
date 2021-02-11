import java.io.*;
import java.util.*;

class baek__6209 {
    static int d;
    static int n;
    static int m;

    static int[] distance;

    static boolean check(int minD) {
        int now = 0;
        int deleted = 0;

        for (int i = 0; i < n; i++) {
            if (distance[i] - now < minD) {
                deleted++;
                continue;
            }
            now = distance[i];
        }

        if (d - now < minD)
            deleted++;

        if (deleted > m)
            return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        d = Integer.parseInt(temp[0]);
        n = Integer.parseInt(temp[1]);
        m = Integer.parseInt(temp[2]);

        distance = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(distance);

        int l = -1;
        int r = d + 1;

        while (l + 1 < r) {
            int mid = (l + r) / 2;

            if (check(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        System.out.print(l);
    }
}
