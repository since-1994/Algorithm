import java.io.*;
import java.util.*;

class baek__17088 {

    static int go(int diff, int[] arr, int cnt) {

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] + 1 == arr[i - 1] + diff) {
                arr[i] += 1;
                cnt++;
            } else if (arr[i] - 1 == arr[i - 1] + diff) {
                arr[i] -= 1;
                cnt++;
            } else if (arr[i] == arr[i - 1] + diff) {

            } else {
                return -1;
            }
        }
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        int ans = -1;

        if (n <= 2) {
            System.out.print(0);
            return;
        }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int[] a = new int[n];
                a = arr.clone();
                a[0] += i;
                a[1] += j;
                int diff = a[1] - a[0];
                int cnt = 2;
                if (i == 0)
                    cnt -= 1;
                if (j == 0)
                    cnt -= 1;
                int result = go(diff, a, cnt);
                if (result != -1) {
                    ans = ans == -1 ? result : Math.min(ans, result);
                }
            }
        }

        System.out.print(ans);
    }
}