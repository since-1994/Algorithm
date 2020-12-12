import java.io.*;
import java.util.*;

class baek__1790 {

    static int calc(int n) {
        int i = 1;
        int len = 0;

        while (n >= Math.pow(10, i)) {
            len += (int) (Math.pow(10, i) - Math.pow(10, i - 1)) * i;
            i++;
        }

        len += (n - (int) Math.pow(10, i - 1) + 1) * i;

        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        if (calc(n) < k) {
            System.out.print(-1);
            return;
        }

        int start = 1;
        int end = n;

        while (start < end) {
            int mid = (start + end) / 2;
            if (calc(mid) >= k) {
                end = mid;
            } else if (calc(mid) < k) {
                start = mid + 1;
            }
        }

        String endToString = Integer.toString(end);
        int before = calc(end - 1);
        System.out.print(endToString.charAt(k - before - 1));

    }
}