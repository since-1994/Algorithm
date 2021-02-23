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

        int i = 0;
        int j = 0;

        int cnt = 0;
        int sum = nums[0];
        while (true) {
            if (sum == m) {
                cnt++;
                sum -= nums[i];
                if (i == j) {
                    i++;
                    j++;
                    if (j == n)
                        break;
                    sum = nums[i];
                } else {
                    i++;
                }
            } else if (sum < m) {
                j++;
                if (j == n)
                    break;
                sum += nums[j];
            } else {
                sum -= nums[i];
                if (i == j) {
                    i++;
                    j++;
                    if (j == n)
                        break;
                    sum = nums[i];
                } else {
                    i++;
                }
            }
        }

        if (sum == m) {
            cnt++;
        }

        System.out.print(cnt);
    }
}
