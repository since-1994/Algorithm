import java.io.*;
import java.util.*;

class baek__10211 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            String[] temp = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(temp[i]);
            }

            int[] s = new int[n + 1];
            s[0] = nums[0];
            for (int i = 1; i < n; i++) {
                s[i] = s[i - 1] + nums[i];
            }
            int answer = -1000 * n - 1;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    answer = Math.max(answer, i - 1 < 0 ? s[j] : s[j] - s[i - 1]);
                }
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb);

    }
}
