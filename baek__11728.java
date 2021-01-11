import java.io.*;
import java.util.*;

class baek__11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

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

        int[] sum = new int[n + m];
        int idx = 0;
        int idx_a = 0;
        int idx_b = 0;

        while (idx_a < n && idx_b < m) {
            if (a[idx_a] < b[idx_b]) {
                sum[idx++] = a[idx_a++];
            } else {
                sum[idx++] = b[idx_b++];
            }
        }

        while (idx_a < n)
            sum[idx++] = a[idx_a++];
        while (idx_b < m)
            sum[idx++] = b[idx_b++];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n + m; i++) {
            sb.append(sum[i] + " ");
        }

        System.out.print(sb);
    }
}