import java.io.*;
import java.util.*;

class baek__2343 {

    static void shuffle(int[] arr) {
        Random random = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    static int calc(int[] arr, int len) {

        int cnt = 0;
        int now = 0;

        for (int i = 0; i < arr.length; i++) {
            if (now + arr[i] > len) {
                cnt++;
                now = 0;
            }
            now += arr[i];
        }

        if (now != 0) {
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[] lessons = new int[n];
        temp = br.readLine().split(" ");
        int left = -1;
        int right = 0;

        for (int i = 0; i < n; i++) {
            lessons[i] = Integer.parseInt(temp[i]);

            right += lessons[i];
            if (left == -1) {
                left = lessons[i];
            } else {
                left = Math.max(left, lessons[i]);
            }
        }

        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (calc(lessons, mid) > m) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        System.out.print(ans);
    }
}