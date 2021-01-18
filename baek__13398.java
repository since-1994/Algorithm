import java.io.*;
import java.util.*;

class baek__13398 {
    static int[] nums = new int[100000];
    static int[] d1;
    static int[] d2;
    static int init;

    static int go1(int n) {
        if (n == 0)
            return nums[0];
        if (d1[n] != init)
            return d1[n];
        d1[n] = Math.max(go1(n - 1) + nums[n], nums[n]);
        return d1[n];
    }

    static int go2(int n, int limit) {
        if (n == limit)
            return nums[n];
        if (d2[n] != init)
            return d2[n];
        d2[n] = Math.max(go2(n + 1, limit) + nums[n], nums[n]);

        return d2[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d1 = new int[n];
        d2 = new int[n];
        init = -1001 * n;
        Arrays.fill(d1, init);
        Arrays.fill(d2, init);

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        int ans = -1000 * n;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, go1(i));
        }
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, go1(i - 1) + go2(i + 1, n - 1));
        }
        System.out.print(ans);
    }
}