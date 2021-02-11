import java.io.*;
import java.util.*;

class baek__20500 {
    static int remain = 1000000007;
    static long[] d = new long[1515 + 1];

    static long go(int n) {
        if (n == 0)
            return 1;

        if (d[n] != -1)
            return d[n];

        d[n] = go(n - 1) % remain * n;
        d[n] %= remain;

        return d[n];
    }

    static long calc(int size1, int size5) {
        long answer = 1;
        answer *= go(size1 + size5);
        answer /= go(size1);
        answer /= go(size5);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = 0;
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(d, -1);

        n -= 1;// 5를 뺴버림
        if (n == 0) {
            System.out.print(0);
            return;
        }

        int size1 = n;
        int size5 = 0;

        while (size1 >= 0) {
            if (((size1 * 1) + (size5 * 5) + 5) % 3 == 0) {
                answer += calc(size1, size5) % remain;
            }
            size1 -= 5;
            size5 += 1;
        }
        System.out.print(answer);
    }
}
