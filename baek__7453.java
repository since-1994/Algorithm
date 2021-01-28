import java.io.*;
import java.util.*;

class baek__7453 {

    static int next(int idx, int[] arr) {
        int cur = arr[idx];

        while (idx < arr.length && arr[idx] == cur) {
            idx++;
        }

        return idx;
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

        int[] arr1 = new int[n * n];
        int[] tempo = new int[n * n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr1[idx] = a[i] + b[j];
                tempo[idx] = c[i] + d[j];
                idx++;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(tempo);

        int[] arr2 = new int[n * n];

        for (int i = 0; i < tempo.length; i++) {
            arr2[i] = tempo[tempo.length - i - 1];
        }

        int l = 0;
        int r = 0;
        long cnt = 0;

        while (l < arr1.length && r < arr2.length) {
            int cur = arr1[l] + arr2[r];

            if (cur == 0) {
                cnt += (long) (next(l, arr1) - l) * (next(r, arr2) - r);
                l = next(l, arr1);
                r = next(r, arr2);
            } else if (cur > 0) {
                r = next(r, arr2);
            } else if (cur < 0) {
                l = next(l, arr1);
            }
        }

        System.out.print(cnt);
    }
}