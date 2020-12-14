import java.io.*;
import java.util.*;

class baek__1517 {

    static int[] arr;
    static int[] merged;
    static long answer = 0;

    static void merge(int start, int end) {
        int mid = (start + end) / 2;

        int k = start;
        int l = start;
        int r = mid + 1;

        while (l <= mid && r <= end) {
            if (arr[l] <= arr[r]) {
                merged[k++] = arr[l++];
            } else if (arr[l] > arr[r]) {
                answer += (mid - l + 1);
                merged[k++] = arr[r++];
            }
        }

        while (l <= mid)
            merged[k++] = arr[l++];
        while (r <= end)
            merged[k++] = arr[r++];

        for (int i = start; i <= end; i++) {
            arr[i] = merged[i];
        }

    }

    static void sort(int start, int end) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        sort(start, mid);
        sort(mid + 1, end);
        merge(start, end);
        // for (int num : arr) {
        // System.out.print(num + " ");
        // }
        // System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        merged = new int[n];

        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        sort(0, n - 1);
        System.out.print(answer);
    }
}