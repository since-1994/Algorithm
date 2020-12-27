import java.io.*;
import java.util.*;

class baek__14225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        boolean[] check = new boolean[20 * 100000 + 1];

        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += arr[j];
                }
            }
            check[sum] = true;
        }

        for (int i = 1; i < check.length; i++) {
            if (!check[i]) {
                System.out.print(i);
                return;
            }
        }
    }
}