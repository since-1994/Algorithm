import java.io.*;
import java.util.*;

class baek__2487 {

    static int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        int g = gcd(a, b);

        return g * (a / g) * (b / g);
    }

    static int go(int now, int[] map, int cnt, int target) {
        if (cnt != 0 && now == target)
            return cnt;

        return go(map[now], map, cnt + 1, target);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        int[] map = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            map[i] = Integer.parseInt(temp[i - 1]);
        }

        int[] cycle = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            cycle[i] = go(i, map, 0, i);
        }

        int answer = 1;

        for (int i = 1; i < n + 1; i++) {
            answer = lcm(answer, cycle[i]);
        }

        System.out.print(answer);
    }
}
