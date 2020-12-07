import java.io.*;
import java.util.*;

class baek__11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(nums);
        int answer = 0;

        for (int i = n; i >= 1; i--) {
            answer += (nums[n - i] * i);
        }

        System.out.print(answer);

    }
}