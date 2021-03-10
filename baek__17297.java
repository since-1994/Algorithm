import java.io.*;
import java.util.*;

class baek__17297 {
    static String[] s = { "Messi ", "Messi Gimossi ", "Messi Gimossi Messi " };
    static ArrayList<Integer> list;

    static String go(int n, int m) {
        if (n <= 2) {
            return s[n].charAt(m - 1) == ' ' ? "Messi Messi Gimossi" : Character.toString(s[n].charAt(m - 1));
        }

        if (list.get(n - 1) + 1 < m) {
            return go(n - 2, m - list.get(n - 1) - 1);
        }
        return go(n - 1, m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        list.add(5);
        list.add(list.get(0) + 1 + 7);
        int i = 1;

        while (list.get(i++) < m) {
            list.add(list.get(i - 1) + 1 + list.get(i - 2));
        }
        i--;
        System.out.print(go(i, m));
    }
}
