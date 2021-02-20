import java.io.*;
import java.util.*;

class baek__11478 {
    static int r = 127;
    static int m = 1000000007;

    static int enc(int start, int end, String og) {
        String s = og.substring(start, end + 1);

        long ans = 0;

        for (int i = 0; i < s.length(); i++) {
            long now = s.charAt(i) - 'a' + 1;
            for (int j = 0; j < i; j++) {
                now *= r;
                now %= m;
            }
            ans += now;
            ans %= m;
        }

        return (int) ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                set.add(s.substring(i, j + 1));
            }
        }

        System.out.print(set.size());
    }
}
