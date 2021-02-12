import java.io.*;
import java.util.*;

class baek__20191 {
    static String s;
    static String t;
    static int[][] next;

    static boolean possible(String s, String t) {
        HashSet<Character> setS = new HashSet<>();
        HashSet<Character> setT = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            setS.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            setT.add(t.charAt(i));
        }
        Iterator iterator = setS.iterator();

        while (iterator.hasNext()) {
            if (!setT.contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    static boolean check(int n) {
        int pointerS = 0;
        int pointerT = 0;

        int cnt = 0;

        while (pointerS < s.length()) {
            pointerT = next[s.charAt(pointerS) - 'a'][pointerT];
            if (pointerT == -1) {
                cnt++;
                pointerT = 0;
            } else {
                pointerT++;
                if (pointerT == t.length()) {
                    cnt++;
                    pointerT = 0;
                }
                pointerS++;
            }
        }
        if (pointerT != 0) {
            cnt++;
        }
        if (cnt > n)
            return false;

        return true;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        t = br.readLine();

        if (!possible(s, t)) {
            System.out.print(-1);
            return;
        }

        next = new int[26][t.length()];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < t.length(); j++) {
                if (t.charAt(j) == (char) ('a' + i)) {
                    next[i][j] = 1;
                }
            }
            int nextIdx = -1;
            for (int j = t.length() - 1; j >= 0; j--) {
                if (next[i][j] == 1) {
                    nextIdx = j;
                }
                next[i][j] = nextIdx;
            }
        }

        int l = -1;
        int r = s.length() + 1;

        while (l + 1 < r) {
            int mid = (l + r) / 2;
            // System.out.println(mid);

            if (check(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.print(r);
    }
}
