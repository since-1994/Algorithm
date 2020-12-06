import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class baek__16197 {
    static int n;
    static int m;

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        map = new char[n][m];
        Node[] points = new Node[2];

        int k = 0;
        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j];
                if (row[j] == 'o') {
                    map[i][j] = '.';
                    points[k++] = new Node(i, j);
                }
            }
        }

        int answer = simul(0, points[0].x, points[0].y, points[1].x, points[1].y);
        System.out.print(answer > 10 ? -1 : answer);

    }

    static int simul(int cnt, int x1, int y1, int x2, int y2) {
        if (cnt > 10) {
            return 11;
        } else {
            if (x1 == -1 && x2 == -1) {
                return 11;
            } else if (x1 == -1 || x2 == -1) {
                return cnt;
            }
        }
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        int returnValue = 11;

        for (int k = 0; k < 4; k++) {
            int nx1 = x1 + dx[k];
            int ny1 = y1 + dy[k];

            int nx2 = x2 + dx[k];
            int ny2 = y2 + dy[k];

            if (nx1 >= 0 && nx1 < n && ny1 >= 0 && ny1 < m) {
                if (map[nx1][ny1] == '#') {
                    nx1 = x1;
                    ny1 = y1;
                }
            } else {
                nx1 = ny1 = -1;
            }
            if (nx2 >= 0 && nx2 < n && ny2 >= 0 && ny2 < m) {
                if (map[nx2][ny2] == '#') {
                    nx2 = x2;
                    ny2 = y2;
                }
            } else {
                nx2 = ny2 = -1;
            }

            returnValue = Math.min(returnValue, simul(cnt + 1, nx1, ny1, nx2, ny2));
        }

        return returnValue;
    }
}