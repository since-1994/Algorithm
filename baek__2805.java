// import java.io.*;
// import java.util.*;

// class baek__2805 {

// static long calc(int[] trees, int n) {
// long tot = 0;

// for (int tree : trees) {
// tot += (tree - n <= 0 ? 0 : tree - n);
// }

// return tot;
// }

// static int go(int[] trees, int max, int target) {

// int start = 0;
// int end = max;

// int ans = -1;

// while (start <= end) {
// int mid = (start + end) / 2;

// if (calc(trees, mid) < target) {
// end = mid - 1;
// } else {
// ans = mid;
// start = mid + 1;
// }
// }

// return ans;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// int[] trees = new int[n];

// temp = br.readLine().split(" ");
// int max = 0;
// for (int i = 0; i < n; i++) {
// trees[i] = Integer.parseInt(temp[i]);
// max = Math.max(trees[i], max);
// }

// System.out.print(go(trees, max, m));
// }
// }

import java.io.*;
import java.util.*;

class baek__2805 {
    static int n;
    static int[] trees;

    static long calc(int mid) {
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i] > mid)
                cnt += trees[i] - mid;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        trees = new int[n];
        temp = br.readLine().split(" ");
        int l = 0;
        int r = Integer.parseInt(temp[0]);
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(temp[i]);
            r = Math.max(r, trees[i]);
        }

        int ans = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            long now = calc(mid);// 총 가져갈 나무

            if (now > m) {
                l = mid + 1;
                ans = Math.max(ans, mid);
            } else if (now == m) {
                l = mid + 1;
                ans = Math.max(ans, mid);
            } else if (now < m) {
                r = mid - 1;
            }
        }

        System.out.print(ans);

    }
}