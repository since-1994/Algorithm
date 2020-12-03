import java.io.*;
import java.util.*;

class baek__2529 {

    static String[] inequality;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        inequality = br.readLine().split(" ");

        int[] big = new int[n + 1];
        int[] small = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            big[i] = 9 - i;
            small[i] = i;
        }

        do {
            if (check(small)) {
                break;
            }
        } while (next_permutation(small));

        do {
            if (check(big)) {
                break;
            }
            // for (int i : big) {
            // System.out.print(i);
            // }
            // System.out.println();
        } while (prev_permutation(big));

        for (int i : big) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : small) {
            System.out.print(i);
        }

    }

    static boolean next_permutation(int[] a) {
        int k = a.length;
        int start = -1;

        for (int i = k - 1; i >= 1; i--) {
            if (a[i - 1] < a[i]) {
                start = i - 1;
                break;
            }
        }

        if (start == -1) {
            return false;
        }

        for (int i = k - 1; i > start; i--) {
            if (a[i] > a[start]) {
                int temp = a[i];
                a[i] = a[start];
                a[start] = temp;
                break;
            }
        }

        start++;
        int end = k - 1;

        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }

        return true;
    }

    static boolean prev_permutation(int[] a) {

        int k = a.length;
        int start = -1;

        for (int i = k - 1; i >= 1; i--) {
            if (a[i - 1] > a[i]) {
                start = i - 1;
                break;
            }
        }

        if (start == -1) {
            return false;
        }

        for (int i = k - 1; i > start; i--) {
            if (a[i] < a[start]) {
                int temp = a[i];
                a[i] = a[start];
                a[start] = temp;
                break;
            }
        }

        start++;
        int end = k - 1;

        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }

        return true;
    }

    static boolean check(int[] a) {
        for (int i = 0; i < n; i++) {
            if (inequality[i].equals("<") && a[i] > a[i + 1]) {
                return false;
            } else if (inequality[i].equals(">") && a[i] < a[i + 1]) {
                return false;
            }
        }

        return true;
    }
}