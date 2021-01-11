import java.io.*;
import java.util.*;

class baek__14002 {
    static int[] d;
    static int[] arr;
    static int[] before;

    static int go(int n) {
        if (d[n] != -1)
            return d[n];

        d[n] = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] < arr[n] && d[n] < go(i) + 1) {
                d[n] = go(i) + 1;
                before[n] = i;
            }
        }

        return d[n];
    }

    static void printReverse(int idx) {
        if (before[idx] == -1) {
            System.out.print(arr[idx] + " ");
            return;
        }
        printReverse(before[idx]);
        System.out.print(arr[idx] + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        d = new int[n];
        before = new int[n];
        Arrays.fill(d, -1);
        Arrays.fill(before, -1);

        int ans = 0;
        int idx = -1;

        for (int i = 0; i < n; i++) {
            if (ans < go(i)) {
                ans = go(i);
                idx = i;
            }
        }

        System.out.println(ans);
        printReverse(idx);
    }
}