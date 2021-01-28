import java.io.*;
import java.util.*;

class baek__2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[] nums = new int[n];

        temp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        int l = 0;
        int r = 0;
        int sum = nums[0];

        int cnt = 0;

        while (r < n) {
            if (sum > m) {
                if (l == r) {
                    sum -= nums[l];
                    l += 1;
                    r += 1;
                    if (r < n)
                        sum = nums[r];
                } else {
                    sum -= nums[l];
                    l += 1;
                }
            } else if (sum == m) {
                cnt += 1;
                if (l == r) {
                    l += 1;
                    r += 1;
                    if (r < n)
                        sum = nums[r];
                } else {
                    sum -= nums[l];
                    l += 1;
                }
            } else {
                r += 1;
                if (r < n)
                    sum += nums[r];
            }
        }

        System.out.print(cnt);

    }
}