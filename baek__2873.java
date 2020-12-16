import java.io.*;
import java.util.*;

class baek__2873 {
    static StringBuilder s1 = new StringBuilder();
    static StringBuilder s2 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int r = Integer.parseInt(temp[0]);
        int c = Integer.parseInt(temp[1]);

        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        if (r % 2 != 0) {
            for (int i = 0; i < r; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < c - 1; j++) {
                        s1.append('R');
                    }
                } else {
                    for (int j = 0; j < c - 1; j++) {
                        s1.append('L');
                    }
                }
                if (i != r - 1) {
                    s1.append('D');
                }
            }
        } else if (c % 2 != 0) {
            for (int i = 0; i < c; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < r - 1; j++) {
                        s1.append('D');
                    }
                } else {
                    for (int j = 0; j < r - 1; j++) {
                        s1.append('U');
                    }
                }
                if (i != c - 1) {
                    s1.append('R');
                }
            }
        } else {
            int x = -1;// 가장 작은 크기의 검은 칸 x
            int y = -1;// 가장 작은 크기의 검은 칸 y

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if ((i + j) % 2 != 0) {// 홀수이면
                        if (x == -1) {
                            x = i;
                            y = j;
                        } else {
                            if (map[i][j] < map[x][y]) {
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            int x1 = 0;
            int y1 = 0;
            int x2 = r - 1;
            int y2 = c - 1;

            while (x1 / 2 != x / 2 || x2 / 2 != x / 2) {
                if (x1 / 2 != x / 2) {
                    for (int i = 0; i < c - 1; i++) {
                        s1.append('R');
                    }
                    s1.append('D');
                    for (int i = 0; i < c - 1; i++) {
                        s1.append('L');
                    }
                    s1.append('D');
                    x1 += 2;
                }
                if (x2 / 2 != x / 2) {
                    for (int i = 0; i < c - 1; i++) {
                        s2.append('R');
                    }
                    s2.append('D');
                    for (int i = 0; i < c - 1; i++) {
                        s2.append('L');
                    }
                    s2.append('D');
                    x2 -= 2;
                }
            }

            while (y1 / 2 != y / 2 || y2 / 2 != y / 2) {
                if (y1 / 2 != y / 2) {
                    s1.append('D');
                    s1.append('R');
                    s1.append('U');
                    s1.append('R');
                    y1 += 2;
                }

                if (y2 / 2 != y / 2) {
                    s2.append('D');
                    s2.append('R');
                    s2.append('U');
                    s2.append('R');
                    y2 -= 2;
                }
            }

            if (y == y1) {
                s1.append('R');
                s1.append('D');
            } else {
                s1.append('D');
                s1.append('R');
            }
            s2.reverse();
            s1.append(s2);
        }
        System.out.print(s1);
    }
}