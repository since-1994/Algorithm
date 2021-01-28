import java.io.*;
import java.util.*;

class baek__1644 {
    static int MAX = 4000000;
    static boolean[] prime;

    static int next(int n) {
        n++;

        while (n < MAX + 1 && !prime[n]) {
            n++;
        }

        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        prime = new boolean[MAX + 1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i <= MAX; i++) {
            if (prime[i] == true) {
                for (int j = i + i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }

        int l = 2;
        int r = 2;
        int sum = 2;
        int cnt = 0;

        while (r <= n) {
            if (sum == n) {
                cnt++;
                if (l == r) {
                    l = next(l);
                    r = next(r);
                    if (r <= n)
                        sum = r;
                } else {
                    sum -= l;
                    l = next(l);
                }
            } else if (sum < n) {
                r = next(r);
                if (r <= n)
                    sum += r;
            } else if (sum > n) {
                if (l == r) {
                    l = next(l);
                    r = next(r);
                    if (r <= n)
                        sum = r;
                } else {
                    sum -= l;
                    l = next(l);
                }
            }
        }

        System.out.print(cnt);

    }
}