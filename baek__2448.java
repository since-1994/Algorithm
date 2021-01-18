// import java.io.*;
// import java.util.*;

// class baek__2448 {

// static char STAR = '*';
// static int[] dx = { 0, 1, 1, 2, 2, 2, 2, 2, };
// static int[] dy = { 0, -1, 1, -1, -2, 2, 1, 0 };
// static char[][] stars;

// static void solve(int x, int y, int h) {
// if (h == 3) {
// for (int k = 0; k < 8; k++) {
// stars[x + dx[k]][y + dy[k]] = STAR;
// }
// return;
// }

// solve(x, y, h / 2);
// solve(x + h / 2, y - h / 2, h / 2);
// solve(x + h / 2, y + h / 2, h / 2);
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());

// stars = new char[n][2 * n];
// for (int i = 0; i < n; i++) {
// Arrays.fill(stars[i], ' ');
// }

// solve(0, n - 1, n);

// for (int i = 0; i < n; i++) {
// System.out.println(String.valueOf(stars[i]));
// }
// }
// }

import java.io.*;
import java.util.*;

class baek__2448 {
    static int[] dx = { 0, 1, 1 };
    static int[] dy = { 0, -1, 1 };
    static char[][] map;
    static char[][] STAR = { { ' ', ' ', '*', ' ', ' ' }, { ' ', '*', ' ', '*', ' ' }, { '*', '*', '*', '*', '*' } };

    static void go(int x, int y, int len) {
        if (len == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    map[x + i][y - 2 + j] = STAR[i][j];
                }
            }
            return;
        }

        int nLen = len / 2;

        for (int k = 0; k < 3; k++) {
            go(x + dx[k] * nLen, y + dy[k] * nLen, nLen);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                map[i][j] = ' ';
            }
        }
        go(0, n - 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}