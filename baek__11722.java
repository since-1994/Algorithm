import java.io.*;
import java.util.*;

class baek__11722 {
    static int[] nums;
    static int[] d;

    static int go(int n) {
        if (n == nums.length - 1) {
            return 1;
        }
        if (d[n] != -1)
            return d[n];

        d[n] = 1;

        for (int i = n + 1; i < nums.length; i++) {
            if (nums[n] > nums[i]) {
                d[n] = Math.max(go(i) + 1, d[n]);
            }
        }

        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d = new int[n];
        Arrays.fill(d, -1);
        nums = new int[n];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, go(i));
        }

        System.out.print(ans);

    }
}