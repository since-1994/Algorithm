import java.io.*;
import java.util.*;

class baek__1182 {

    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        target = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        System.out.print(go(nums, 0, 0, 0));
    }

    static int go(int[] nums, int cnt, int sum, int idx) {
        if (idx == nums.length) {
            if (cnt == 0)
                return 0;
            else if (sum == target)
                return 1;
            return 0;
        }

        int returnValue = 0;
        returnValue += go(nums, cnt + 1, sum + nums[idx], idx + 1);
        returnValue += go(nums, cnt, sum, idx + 1);

        return returnValue;
    }
}
