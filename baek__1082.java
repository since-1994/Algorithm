import java.io.*;
import java.util.*;

class baek__1082 {
    static int[] cost;
    static String[] d = new String[51];

    static String go(int n, boolean first) {
        if (n <= 0) {
            if (n == 0) {
                return "";
            }
            return "-";
        }

        if (!d[n].equals(""))
            return d[n];

        for (int i = first ? 1 : 0; i < cost.length; i++) {
            String s = Integer.toString(i) + go(n - cost[i], false);
            if (compare(d[n], s) < 0) {
                d[n] = s;
            }
        }

        return d[n];
    }

    static int compare(String a, String b) {
        if (a.length() > 0 && a.indexOf('-') != -1 && b.length() > 0 && b.indexOf('-') != -1)
            return 0;
        if (a.length() > 0 && a.indexOf('-') != -1) {
            return -1;
        }
        if (b.length() > 0 && b.indexOf('-') != -1)
            return 1;

        if (a.length() != b.length())
            return a.length() - b.length();

        return a.compareTo(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        cost = new int[n];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(temp[i]);
        }

        int tot = Integer.parseInt(br.readLine());

        Arrays.fill(d, "");
        System.out.print(go(tot, true));
    }
}
