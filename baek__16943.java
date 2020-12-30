import java.io.*;
import java.util.*;

class baek__16943 {

    static boolean next_permutation(char[] arr) {
        int n = arr.length;
        int start = -1;

        for (int i = n - 1; i >= 1; i--) {
            if (arr[i - 1] < arr[i]) {
                start = i - 1;
                break;
            }
        }

        if (start == -1) {
            return false;
        }

        for (int i = n - 1; i > start; i--) {
            if (arr[i] > arr[start]) {
                char temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
                break;
            }
        }

        start += 1;
        int end = arr.length - 1;

        while (start <= end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return true;
    }

    static int make_int(char[] arr) {
        int num = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] == '0')
                return -1;
            num *= 10;
            num += (arr[i] - '0');
        }

        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        char[] a = temp[0].toCharArray();
        int b = Integer.parseInt(temp[1]);

        int ans = -1;
        Arrays.sort(a);

        do {
            int aInt = make_int(a);
            if (aInt <= b) {
                ans = Math.max(ans, aInt);
            }
        } while (next_permutation(a));

        System.out.print(ans);
    }
}