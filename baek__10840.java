import java.io.*;
import java.util.*;

class baek__10840 {
    static String s;
    static String t;

    static int r1 = 127;
    static int r2 = 31;
    static int m1 = 1000000007;
    static int m2 = 1234567891;

    static long[] hashS1;
    static long[] hashS2;
    static long[] hashT1;
    static long[] hashT2;

    static boolean check(int len) {
        for (int i = 0; i < s.length() - len + 1; i++) {
            long a1 = i - 1 == -1 ? hashS1[i + len - 1] : hashS1[i + len - 1] - hashS1[i - 1];
            a1 += m1;
            a1 %= m1;
            long a2 = i - 1 == -1 ? hashS2[i + len - 1] : hashS2[i + len - 1] - hashS2[i - 1];
            a2 += m2;
            a2 %= m2;

            for (int j = 0; j < t.length() - len + 1; j++) {
                long b1 = j - 1 == -1 ? hashT1[j + len - 1] : hashT1[j + len - 1] - hashT1[j - 1];
                b1 += m1;
                b1 %= m1;
                long b2 = j - 1 == -1 ? hashT2[j + len - 1] : hashT2[j + len - 1] - hashT2[j - 1];
                b2 += m2;
                b2 %= m2;

                if (a1 == b1 && a2 == b2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        t = br.readLine();

        long[] power1 = new long[26];
        long[] power2 = new long[26];

        power1[0] = 1;
        power2[0] = 1;
        for (int i = 1; i < 26; i++) {
            power1[i] = power1[i - 1] * r1;
            power1[i] %= m1;

            power2[i] = power2[i - 1] * r2;
            power2[i] %= m2;
        }

        hashS1 = new long[s.length()];
        hashS2 = new long[s.length()];
        hashT1 = new long[t.length()];
        hashT2 = new long[t.length()];

        hashS1[0] = power1[s.charAt(0) - 'a'];
        hashS2[0] = power2[s.charAt(0) - 'a'];
        hashT1[0] = power1[t.charAt(0) - 'a'];
        hashT2[0] = power2[t.charAt(0) - 'a'];

        for (int i = 1; i < s.length(); i++) {
            hashS1[i] = hashS1[i - 1] + power1[s.charAt(i) - 'a'];
            hashS1[i] %= m1;

            hashS2[i] = hashS2[i - 1] + power2[s.charAt(i) - 'a'];
            hashS2[i] %= m2;
        }

        for (int i = 1; i < t.length(); i++) {
            hashT1[i] = hashT1[i - 1] + power1[t.charAt(i) - 'a'];
            hashT1[i] %= m1;

            hashT2[i] = hashT2[i - 1] + power2[t.charAt(i) - 'a'];
            hashT2[i] %= m2;
        }

        int l = 0;
        int r = Math.min(s.length(), t.length()) + 1;

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
