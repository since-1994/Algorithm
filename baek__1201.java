import java.io.*;
import java.util.*;

class baek__1201 {

    static int n;
    static int m;
    static int k;

    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        k = Integer.parseInt(temp[2]);

        if (n < (m + k - 1)) {
            System.out.print(-1);
            return;
        } else if (m * k < n) {
            System.out.print(-1);
            return;
        }

        a = new int[n];

        for (int i = 1; i < n + 1; i++) {
            a[i - 1] = i;
        }

        ArrayList<Integer> g = new ArrayList<>();

        g.add(0);
        g.add(k);

        int addedNum = m - 1 == 0 ? 1 : (n - k) / (m - 1);
        int remain = m - 1 == 0 ? 0 : (n - k) % (m - 1);
        int next = m - 1 == 0 ? 0 : k + addedNum;

        while (next < n + 1) {
            if (remain == 0) {
                g.add(next);
            } else {
                g.add(next + 1);
                next += 1;
                remain -= 1;
            }
            next += addedNum;
        }

        for (int i = 0; i < g.size() - 1; i++) {
            makeReverse(g.get(i), g.get(i + 1) - 1);
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    static void makeReverse(int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }
    }
}