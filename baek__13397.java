import java.io.*;
import java.util.*;

class baek__13397 {

    static int calc(int[] arr, int limit) {

        int cnt = 0;
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {

            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if (max - min > limit) {
                cnt++;

                min = arr[i];
                max = arr[i];
            }
        }
        cnt++;

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[] arr = new int[n];

        temp = br.readLine().split(" ");
        int min = -1;
        int max = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
            if (min == -1 || min > arr[i])
                min = arr[i];

            if (max == -1 || max < arr[i]) {
                max = arr[i];
            }
        }

        int left = 0;
        int right = max - min;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (calc(arr, mid) > m) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        System.out.print(ans);

    }
}