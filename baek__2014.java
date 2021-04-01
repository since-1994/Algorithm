import java.io.*;
import java.util.*;

class baek__2014 {

    static int factorization(int n) {
        int max = -1;

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                max = i;
                n /= i;
            }
        }

        if (n != 1)
            max = n;

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int k = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);

        int[] prime = new int[k];
        temp = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            prime[i] = Integer.parseInt(temp[i]);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        q.add(1);
        int cnt = -1;
        int answer = -1;

        while (true) {
            int now = q.poll();
            cnt++;

            if (cnt == n) {
                answer = (int) now;
                break;
            }

            int max = factorization(now);

            for (int p : prime) {
                if (p < max)
                    continue;

                long nex = (long) now * p;

                if (nex < (long) (1 << 30) * 2)
                    q.add((int) nex);
            }
        }

        System.out.print(answer);

    }
}
