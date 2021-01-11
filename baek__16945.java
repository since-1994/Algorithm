import java.io.*;
import java.util.*;

class baek__16945 {
    static int ans = 90;
    static int[] map = new int[9];
    static boolean[] check = new boolean[10];

    static int calc(int[] arr) {
        int tot = 0;

        for (int i = 0; i < 9; i++) {
            tot += Math.abs(arr[i] - map[i]);
        }
        return tot;
    }

    static boolean ms(int[] arr) {
        int magic = arr[0] + arr[1] + arr[2];

        if (magic != arr[3] + arr[4] + arr[5])
            return false;
        if (magic != arr[6] + arr[7] + arr[8])
            return false;

        if (magic != arr[0] + arr[3] + arr[6])
            return false;
        if (magic != arr[1] + arr[4] + arr[7])
            return false;
        if (magic != arr[2] + arr[5] + arr[8])
            return false;

        if (magic != arr[0] + arr[4] + arr[8])
            return false;
        if (magic != arr[2] + arr[4] + arr[6])
            return false;

        return true;
    }

    static void go(int idx, int[] arr) {
        if (idx == 9) {
            if (ms(arr)) {
                ans = Math.min(ans, calc(arr));
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[idx] = i;
                go(idx + 1, arr);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            map[i] = sc.nextInt();
        }

        int[] arr = new int[9];
        go(0, arr);

        System.out.print(ans);
    }
}