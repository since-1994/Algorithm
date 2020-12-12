import java.io.*;
import java.util.*;

class baek__11782 {
    static int[] merged;

    static void merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                merged[k++] = a[i++];
            } else if (a[i] > b[j]) {
                merged[k++] = b[j++];
            } else {
                merged[k++] = b[j++];
            }
        }
        while (i < a.length)
            merged[k++] = a[i++];
        while (j < b.length)
            merged[k++] = b[j++];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        merged = new int[n + m];
        int[] a = new int[n];
        int[] b = new int[m];

        temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(temp[i]);
        }

        temp = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(temp[i]);
        }

        merge(a, b);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n + m; i++) {
            sb.append(merged[i] + " ");
        }
        System.out.print(sb);
    }
}