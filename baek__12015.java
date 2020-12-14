import java.io.*;
import java.util.*;

class baek__12015 {
    static ArrayList<Integer> sorted = new ArrayList<>();
    static int[] arr;

    static int lower_bound(int idx) {

        int target = arr[idx];

        int start = 0;
        int end = sorted.size() - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (sorted.get(mid) == target) {
                ans = mid;
                end = mid - 1;
            } else if (sorted.get(mid) < target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        for (int i = 0; i < n; i++) {
            int idx = lower_bound(i);
            if (idx == -1) {
                sorted.add(arr[i]);
            } else {
                sorted.set(idx, arr[i]);
            }
        }

        System.out.print(sorted.size());
        // for (int i = 0; i < sorted.size(); i++) {
        // System.out.print(sorted.get(i) + " ");
        // }
        // System.out.println();

    }
}