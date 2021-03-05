import java.io.*;
import java.util.*;

class baek__9251 {
    static String s;
    static String ss;
    static int[][] d = new int[1000][1000];

    static int go(int i, int j) {
        if (i < 0 || j < 0)
            return 0;

        if (d[i][j] != -1) {
            return d[i][j];
        }

        int a = go(i - 1, j - 1);
        if (s.charAt(i) == ss.charAt(j))
            a++;

        int b = go(i - 1, j);
        int c = go(i, j - 1);

        d[i][j] = Math.max(a, b);
        d[i][j] = Math.max(d[i][j], c);

        return d[i][j];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        ss = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < ss.length(); j++) {
                d[i][j] = -1;
            }
        }

        System.out.print(go(s.length() - 1, ss.length() - 1));
    }
}
