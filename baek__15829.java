import java.io.*;
import java.util.*;

class baek__15829 {
    static int r = 31;
    static int MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long ans = 0;
        long[] power = new long[s.length()];
        power[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            power[i] = power[i - 1] * r;
            power[i] %= MOD;
        }
        for (int i = 0; i < s.length(); i++) {
            long j = s.charAt(i) - 'a' + 1;
            j *= power[i];
            j %= MOD;
            ans += j;
            ans %= MOD;
        }

        System.out.print(ans);
    }
}
