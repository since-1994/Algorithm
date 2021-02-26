import java.io.*;
import java.util.*;

class baek__17609 {

    static int go(String s, int p1, int p2, int chance) {
        if (p1 > p2) {
            if (chance > 0)
                return 0;
            return 1;
        }

        if (s.charAt(p1) == s.charAt(p2)) {
            return go(s, p1 + 1, p2 - 1, chance);
        } else if (chance > 0) {
            int a = 2;
            int b = 2;
            if (s.charAt(p1 + 1) == s.charAt(p2)) {
                a = go(s, p1 + 2, p2 - 1, chance - 1);
            }
            if (s.charAt(p1) == s.charAt(p2 - 1)) {
                b = go(s, p1 + 1, p2 - 2, chance - 1);
            }
            return Math.min(a, b);
        }

        return 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            String s = br.readLine();
            sb.append(go(s, 0, s.length() - 1, 1) + "\n");
        }

        System.out.print(sb);
    }
}
