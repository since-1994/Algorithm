import java.io.*;
import java.util.*;

class baek__16922 {
    static int n;
    static boolean[] check = new boolean[50 * 20 + 1];
    static int[] num = { 1, 5, 10, 50 };

    static int go(int index, int cnt, int sum) {
        if (index == 4) {
            if (cnt != n)
                return 0;
            if (check[sum])
                return 0;

            check[sum] = true;
            return 1;
        }

        int returnValue = 0;

        for (int i = 0; i <= n; i++) {
            returnValue += go(index + 1, cnt + i, sum + (num[index] * i));
        }

        return returnValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        System.out.print(go(0, 0, 0));

    }
}