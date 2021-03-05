import java.io.*;
import java.util.*;

class baek__7453 {

    static int lower_bound(int target, int[] arr) {
        int l = -1;
        int r = arr.length;

        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return r;
    }

    static int upper_bound(int target, int[] arr) {
        int l = -1;
        int r = arr.length;

        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return r;
    }

    static int find(int target, int[] arr) {
        return upper_bound(target, arr) - lower_bound(target, arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            a[i] = Integer.parseInt(temp[0]);
            b[i] = Integer.parseInt(temp[1]);
            c[i] = Integer.parseInt(temp[2]);
            d[i] = Integer.parseInt(temp[3]);
        }

        int[] arr = new int[n * n];
        int[] brr = new int[n * n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx] = a[i] + b[j];
                brr[idx] = c[i] + d[j];
                idx++;
            }
        }

        Arrays.sort(arr);
        Arrays.sort(brr);

        long ans = 0;
        int i = 0;
        while (i < arr.length) {
            int next = upper_bound(arr[i], arr);
            ans += 1L * (next - i) * find(-arr[i], brr);
            i = next;
        }

        System.out.print(ans);
    }
}
