import java.io.*;
import java.util.*;

class baek__17968 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[1001];

        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            int k = 1;
            boolean[] possible = new boolean[1001];
            Arrays.fill(possible, true);
            while (i - 2 * k >= 0) {
                int diff = nums[i - k] - nums[i - 2 * k];
                if (nums[i - k] + diff > 0)
                    possible[nums[i - k] + diff] = false;
                k++;
            }

            for (int j = 1; j < 1001; j++) {
                if (possible[j]) {
                    nums[i] = j;
                    break;
                }
            }
        }

        System.out.print(nums[n]);
    }
}
