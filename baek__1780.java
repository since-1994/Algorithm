import java.io.*;
import java.util.*;

class Pair {
    int target;
    boolean isRight;

    Pair(int target, boolean isRight) {
        this.target = target;
        this.isRight = isRight;
    }
}

class baek__1780 {

    static int[][] paper;
    static int ans1 = 0;
    static int ans2 = 0;
    static int ans3 = 0;

    static Pair check(int x, int y, int n) {

        int targetNumber = -2;

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (targetNumber == -2) {
                    targetNumber = paper[i][j];
                }
                if (targetNumber != paper[i][j]) {
                    return new Pair(-2, false);
                }
            }
        }

        return new Pair(targetNumber, true);
    }

    static void solve(int x, int y, int n) {

        int m = n / 3;
        Pair pair = check(x, y, n);
        if (pair.isRight == false) {
            for (int i = x; i < x + n; i += m) {
                for (int j = y; j < y + n; j += m) {
                    solve(i, j, m);
                }
            }
        } else {
            if (pair.target == -1)
                ans1++;
            else if (pair.target == 0)
                ans2++;
            else
                ans3++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(temp[j]);
            }
        }

        solve(0, 0, n);

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}