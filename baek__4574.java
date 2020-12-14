import java.io.*;
import java.util.*;

class baek__4574 {
    static StringBuilder sb = new StringBuilder();

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static boolean[][] check_col;
    static boolean[][] check_row;
    static boolean[][] check_sqr;

    static int[][] map;
    static boolean[][] domino;

    static boolean go(int idx) {
        if (idx == 81) {
            return true;
        }

        int x = idx / 9;
        int y = idx % 9;

        if (map[x][y] != 0) {
            return go(idx + 1);
        }
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j)
                    continue;
                if (domino[i][j])
                    continue;

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < 9 && ny >= 0 && ny < 9 && map[nx][ny] == 0) {
                        if (check_col[y][i])
                            continue;
                        if (check_row[x][i])
                            continue;
                        if (check_sqr[(x / 3) * 3 + (y / 3)][i])
                            continue;
                        if (check_col[ny][j])
                            continue;
                        if (check_row[nx][j])
                            continue;
                        if (check_sqr[(nx / 3) * 3 + (ny / 3)][j])
                            continue;

                        check_col[y][i] = true;
                        check_row[x][i] = true;
                        check_sqr[(x / 3) * 3 + (y / 3)][i] = true;
                        check_col[ny][j] = true;
                        check_row[nx][j] = true;
                        check_sqr[(nx / 3) * 3 + (ny / 3)][j] = true;
                        domino[i][j] = domino[j][i] = true;
                        map[x][y] = i;
                        map[nx][ny] = j;

                        if (go(idx + 1))
                            return true;

                        check_col[y][i] = false;
                        check_row[x][i] = false;
                        check_sqr[(x / 3) * 3 + (y / 3)][i] = false;
                        check_col[ny][j] = false;
                        check_row[nx][j] = false;
                        check_sqr[(nx / 3) * 3 + (ny / 3)][j] = false;
                        domino[i][j] = domino[j][i] = false;
                        map[x][y] = 0;
                        map[nx][ny] = 0;
                    }
                }

            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 1;
        while (true) {
            check_col = new boolean[9][10];
            check_row = new boolean[9][10];
            check_sqr = new boolean[9][10];

            map = new int[9][9];
            domino = new boolean[10][10];

            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                System.out.print(sb);
                return;
            }
            String[] temp;
            while (n-- > 0) {
                temp = br.readLine().split(" ");
                int n1 = Integer.parseInt(temp[0]);
                char[] position1 = temp[1].toCharArray();
                map[position1[0] - 'A'][position1[1] - '1'] = n1;
                check_row[position1[0] - 'A'][n1] = true;
                check_col[position1[1] - '1'][n1] = true;
                check_sqr[((position1[0] - 'A') / 3) * 3 + ((position1[1] - '1') / 3)][n1] = true;

                int n2 = Integer.parseInt(temp[2]);
                char[] position2 = temp[3].toCharArray();
                map[position2[0] - 'A'][position2[1] - '1'] = n2;
                check_row[position2[0] - 'A'][n2] = true;
                check_col[position2[1] - '1'][n2] = true;
                check_sqr[((position2[0] - 'A') / 3) * 3 + ((position2[1] - '1') / 3)][n2] = true;

                domino[n1][n2] = true;
                domino[n2][n1] = true;
            }
            temp = br.readLine().split(" ");
            for (int i = 0; i < 9; i++) {
                char[] position = temp[i].toCharArray();
                map[position[0] - 'A'][position[1] - '1'] = i + 1;
                check_row[position[0] - 'A'][i + 1] = true;
                check_col[position[1] - '1'][i + 1] = true;
                check_sqr[((position[0] - 'A') / 3) * 3 + ((position[1] - '1') / 3)][i + 1] = true;
            }

            go(0);
            sb.append("Puzzle " + k++ + "\n");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
    }
}