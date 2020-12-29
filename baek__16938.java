import java.io.*;
import java.util.*;

class baek__16938 {

    static int n, l, r, x;
    static int[] problems;

    static int go(int index, int cnt, int sum, int min, int max) {
        if (index == problems.length) {
            if (cnt >= 2 && sum >= l && sum <= r && max - min >= x) {
                return 1;
            }
            return 0;
        }

        int returnValue = 0;

        returnValue += go(index + 1, cnt, sum, min, max);
        returnValue += go(index + 1, cnt + 1, sum + problems[index],
                min == 0 ? problems[index] : Math.min(problems[index], min), Math.max(problems[index], max));

        return returnValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        l = Integer.parseInt(temp[1]);
        r = Integer.parseInt(temp[2]);
        x = Integer.parseInt(temp[3]);

        problems = new int[n];

        temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            problems[i] = Integer.parseInt(temp[i]);
        }

        System.out.print(go(0, 0, 0, 0, 0));
    }
}