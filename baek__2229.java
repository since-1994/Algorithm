import java.io.*;
import java.util.*;

class baek__2229 {
    static int[] d;
    static int[] arr;

    static int go(int i) {
        if (i <= 0) {
            return 0;
        }

        if (d[i] != -1) {
            return d[i];
        }

        d[i] = 0;
        int max = arr[i];
        int min = arr[i];

        for (int j = i - 1; j >= 0; j--) {
            max = Math.max(max, arr[j]);
            min = Math.min(min, arr[j]);
            d[i] = Math.max(max - min + go(j - 1), go(i));
        }

        return d[i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        d = new int[n];
        Arrays.fill(d, -1);

        System.out.print(go(n - 1));

    }
}
