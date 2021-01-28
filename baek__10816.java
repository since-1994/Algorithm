import java.io.*;
import java.util.*;

class baek__10816 {

    static int n;
    static int[] card;

    static int lower_bound(int target) {
        int start = 0;
        int end = n - 1;

        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (card[mid] == target) {
                end = mid - 1;
                ans = mid;
            } else if (card[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;

    }

    static int upper_bound(int target) {
        int start = 0;
        int end = n - 1;

        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (card[mid] == target) {
                start = mid + 1;
                ans = mid;
            } else if (card[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans + 1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        card = new int[n];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(card);

        int m = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(temp[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            int l = lower_bound(target);
            int r = upper_bound(target);
            sb.append(l == -1 ? "0 " : (r - l) + " ");
        }

        System.out.print(sb);
    }
}