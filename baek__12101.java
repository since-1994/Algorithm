import java.io.*;
import java.util.*;

class baek__12101 {

    static String e = "";
    static int k;

    static void go(int target, int sum, String ans) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            k--;
            if (k == 0)
                e = ans;
            return;
        }

        go(target, sum + 1, ans + "1");
        go(target, sum + 2, ans + "2");
        go(target, sum + 3, ans + "3");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        k = Integer.parseInt(temp[1]);

        go(n, 0, "");
        if (e.equals("")) {
            System.out.print(-1);
            return;
        } else {
            for (int i = 0; i < e.length() - 1; i++) {
                System.out.print(e.charAt(i) + "+");
            }
            System.out.print(e.charAt(e.length() - 1));
        }
    }
}