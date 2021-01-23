import java.io.*;
import java.util.*;

class baek__1790 {

    static int len(int n) {
        int length = 1;
        int now = 10;
        int cnt = 0;

        while (true) {
            if (n >= now - 1) {
                cnt += (now - (now / 10)) * length;
                now *= 10;
                length += 1;
            } else {
                cnt += (n - (now / 10) + 1) * length;
                break;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        int left = 1;
        int right = n;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int now = len(mid);

            if (now < k) {
                left = mid + 1;
            } else if (now == k) {
                ans = mid;
                break;
            } else if (now > k) {
                ans = mid;
                right = mid - 1;
            }
        }

        if (ans == -1) {
            System.out.print(ans);
            return;
        }
        int diff = k - len(ans - 1);
        String ansStr = Integer.toString(ans);
        System.out.print(ansStr.charAt(diff - 1));

    }
}