import java.io.*;
import java.util.*;

class baek__13713 {

    static int r1 = 127;
    static int m1 = 1000000007;

    static int r2 = 31;
    static int m2 = 1000000007;

    static int[] hash1;
    static int[] hash2;
    static long[][] power;

    static int[] hashing(String s, int r, int m, long[] power) {
        int[] arr = new int[s.length() + 1];

        for (int i = s.length() - 1; i >= 0; i--) {
            long before = 1L * arr[i + 1] * r;
            before %= m;
            before += (s.charAt(i) - 'a' + 1);
            before %= m;
            arr[i] = (int) before;
        }

        return arr;
    }

    static boolean check(int sl, int sr, int tl, int tr) {
        long a1 = hash1[sl] - hash1[sr] * power[1][sr - sl] % m1;
        a1 += m1;
        a1 %= m1;
        long b1 = hash1[tl] - hash1[tr] * power[1][tr - tl] % m1;
        b1 += m1;
        b1 %= m1;

        long a2 = hash2[sl] - hash2[sr] * power[2][sr - sl] % m2;
        a2 += m2;
        a2 %= m2;
        long b2 = hash2[tl] - hash2[tr] * power[2][tr - tl] % m2;
        b2 += m2;
        b2 %= m2;
        if (a1 == b1 && a2 == b2)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int size = Integer.parseInt(br.readLine());

        power = new long[3][s.length() + 1];
        power[1][0] = 1;
        power[2][0] = 1;
        for (int i = 1; i < s.length(); i++) {
            power[1][i] = power[1][i - 1] * r1;
            power[1][i] %= m1;
            power[2][i] = power[2][i - 1] * r2;
            power[2][i] %= m2;
        }

        hash1 = new int[s.length() + 1];
        hash2 = new int[s.length() + 1];
        hash1 = hashing(s, r1, m1, power[1]);
        hash2 = hashing(s, r2, m2, power[2]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int n = Integer.parseInt(br.readLine());

            int l = 0;
            int r = n + 1;

            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (check(s.length() - mid, s.length(), n - mid, n)) {
                    l = mid;
                } else {
                    r = mid;
                }
            }

            sb.append(l + "\n");
        }

        System.out.print(sb);
    }
}
