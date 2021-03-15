import java.io.*;
import java.util.*;

class baek__1082 {
    static int[] cost;
    static String[] d = new String[51];

    static String go(int n) {
        if (n <= 0) {
            if (n == 0) {
                return "";
            }
            return "-";
        }

        if (!d[n].equals(""))
            return d[n];

        for (int i = 0; i < cost.length; i++) {
            if (compare(d[n], go(n - cost[i]) + Integer.toString(i)) < 0) {
                d[n] = go(n - cost[i]) + Integer.toString(i);
            }
        }

        return d[n];
    }

    static int compare(String a, String b) {
        // if (a.length() > 0 && a.charAt(0) == '-' && b.length() > 0 && b.charAt(0) ==
        // '-')
        // return 0;
        // if (a.length() > 0 && a.charAt(0) == '-') {
        // return -1;
        // }
        // if (b.length() > 0 && b.charAt(0) == '-')
        // return 1;

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
        System.out.print(go(tot));
    }
}
