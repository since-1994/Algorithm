// import java.io.*;
// import java.util.*;

// class baek__13397 {

// static int calc(int[] arr, int limit) {

// int cnt = 0;
// int min = arr[0];
// int max = arr[0];

// for (int i = 0; i < arr.length; i++) {

// min = Math.min(min, arr[i]);
// max = Math.max(max, arr[i]);

// if (max - min > limit) {
// cnt++;

// min = arr[i];
// max = arr[i];
// }
// }
// cnt++;

// return cnt;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// int[] arr = new int[n];

// temp = br.readLine().split(" ");
// int min = -1;
// int max = -1;

// for (int i = 0; i < n; i++) {
// arr[i] = Integer.parseInt(temp[i]);
// if (min == -1 || min > arr[i])
// min = arr[i];

// if (max == -1 || max < arr[i]) {
// max = arr[i];
// }
// }

// int left = 0;
// int right = max - min;
// int ans = -1;

// while (left <= right) {
// int mid = (left + right) / 2;

// if (calc(arr, mid) > m) {
// left = mid + 1;
// } else {
// ans = mid;
// right = mid - 1;
// }
// }

// System.out.print(ans);

// }
// }
import java.io.*;
import java.util.*;

class baek__13397 {
    static int n;
    static int m;
    static int[] nums;

    static boolean check(int limit) {
        int min = nums[0];
        int max = nums[0];

        int cnt = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                if (max - nums[i] > limit) {
                    min = nums[i];
                    max = nums[i];
                    cnt++;
                } else {
                    min = nums[i];
                }
            } else if (nums[i] > max) {
                if (nums[i] - min > limit) {
                    max = nums[i];
                    min = nums[i];
                    cnt++;
                } else {
                    max = nums[i];
                }
            }
        }

        if (cnt > m)
            return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");
        nums = new int[n];

        int l = 0;
        int r = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
            r = Math.max(nums[i], r);
        }

        int ans = r;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (check(mid)) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.print(ans);

    }
}