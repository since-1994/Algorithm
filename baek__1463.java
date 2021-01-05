import java.io.*;
import java.util.*;

class baek__1463 {
    static int n;

    static int[] d;

    static int go(int num) {
        if (num == 1)
            return 0;

        if (d[num] != -1) {
            return d[num];
        }

        d[num] = go(num - 1) + 1;

        if (num % 3 == 0) {
            int temp = go(num / 3) + 1;
            if (d[num] > temp) {
                d[num] = temp;
            }
        }
        if (num % 2 == 0) {
            int temp = go(num / 2) + 1;
            if (d[num] > temp) {
                d[num] = temp;
            }
        }

        return d[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        Arrays.fill(d, -1);
        System.out.print(go(n));
    }
}