import java.io.*;
import java.util.*;

class baek__1654 {

    static int[] lines;

    static int calc(int length) {
        int cnt = 0;

        for (int line : lines) {
            cnt += (line / length);
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        lines = new int[n];

        for (int i = 0; i < n; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);

        int start = 1;
        int end = lines[lines.length - 1];
        int i = 0;

        while (start < end) {
            i++;
            if (i > 30)
                break;
            System.out.println(start + " " + end);
            int mid = (start + end) / 2;

            if (calc(mid) < k) {
                end = mid - 1;
            } else if (calc(mid) > k) {
                start = mid;
            }
        }

        System.out.print(end);
    }
}