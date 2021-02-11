import java.io.*;
import java.util.*;

class baek__1920 {

    static int find(int target, int[] nums) {
        int start = -1;
        int end = nums.length;

        while (start + 1 < end) {
            int m = (start + end) / 2;

            if (nums[m] <= target) {
                start = m;
            } else if (nums[m] > target) {
                end = m;
            }
        }
        if (start == -1)
            return 0;
        return nums[start] == target ? 1 : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(temp[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(find(targets[i], nums) + "\n");
        }

        System.out.print(sb);
    }
}
