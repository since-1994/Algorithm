// import java.io.*;
// import java.util.*;

// class Pair {
// int target;
// boolean isRight;

// Pair(int target, boolean isRight) {
// this.target = target;
// this.isRight = isRight;
// }
// }

// class baek__1780 {

// static int[][] paper;
// static int ans1 = 0;
// static int ans2 = 0;
// static int ans3 = 0;

// static Pair check(int x, int y, int n) {

// int targetNumber = -2;

// for (int i = x; i < x + n; i++) {
// for (int j = y; j < y + n; j++) {
// if (targetNumber == -2) {
// targetNumber = paper[i][j];
// }
// if (targetNumber != paper[i][j]) {
// return new Pair(-2, false);
// }
// }
// }

// return new Pair(targetNumber, true);
// }

// static void solve(int x, int y, int n) {

// int m = n / 3;
// Pair pair = check(x, y, n);
// if (pair.isRight == false) {
// for (int i = x; i < x + n; i += m) {
// for (int j = y; j < y + n; j += m) {
// solve(i, j, m);
// }
// }
// } else {
// if (pair.target == -1)
// ans1++;
// else if (pair.target == 0)
// ans2++;
// else
// ans3++;
// }
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());

// paper = new int[n][n];

// String[] temp;
// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// for (int j = 0; j < n; j++) {
// paper[i][j] = Integer.parseInt(temp[j]);
// }
// }

// solve(0, 0, n);

// System.out.println(ans1);
// System.out.println(ans2);
// System.out.println(ans3);
// }
// }

import java.io.*;
import java.util.*;

class baek__1780 {
    static int[][] map;
    static int[] count = new int[3];
    static int[] dx = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
    static int[] dy = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };

    static void go(int x, int y, int len) {

        int color = -1;

        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (color == -1)
                    color = map[i][j];
                else if (color != map[i][j]) {
                    int nextLen = len / 3;
                    for (int k = 0; k < 9; k++) {
                        go(x + dx[k] * nextLen, y + dy[k] * nextLen, nextLen);
                    }
                    return;
                }
            }
        }

        count[color] += 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]) + 1;
            }
        }

        go(0, 0, n);
        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }
    }
}