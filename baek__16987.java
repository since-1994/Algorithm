import java.io.*;
import java.util.*;

class baek__16987 {

    static int n;

    static int count(int[] s) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] <= 0)
                cnt++;
        }
        return cnt;
    }

    static int go(int a, int[] s, int[] w) {
        if (a == n) {
            return count(s);
        }

        if (s[a] <= 0)
            return go(a + 1, s, w);

        int ans = 0;
        boolean thereIsUncrashed = false;

        for (int b = 0; b < n; b++) {
            if (a == b)
                continue;
            if (s[b] <= 0)
                continue;
            s[a] -= w[b];
            s[b] -= w[a];
            ans = Math.max(ans, go(a + 1, s, w));
            thereIsUncrashed = true;
            s[a] += w[b];
            s[b] += w[a];
        }

        if (thereIsUncrashed)
            return ans;
        return go(a + 1, s, w);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] s = new int[n];
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            s[i] = Integer.parseInt(temp[0]);
            w[i] = Integer.parseInt(temp[1]);
        }

        System.out.print(go(0, s.clone(), w.clone()));
    }
}