import java.io.*;
import java.util.*;

class baek__9663 {

    static int n;
    static boolean[] check_col;
    static boolean[] check_dig1;
    static boolean[] check_dig2;

    static int go(int idx) {
        if (idx == n) {
            return 1;
        }
        int returnValue = 0;

        for (int i = 0; i < n; i++) {
            if (check_col[i] == false && check_dig1[idx + i] == false && check_dig2[idx - i + n - 1] == false) {
                check_col[i] = true;
                check_dig1[idx + i] = true;
                check_dig2[idx - i + n - 1] = true;
                returnValue += go(idx + 1);
                check_col[i] = false;
                check_dig1[idx + i] = false;
                check_dig2[idx - i + n - 1] = false;
            }
        }

        return returnValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        check_col = new boolean[n];
        check_dig1 = new boolean[2 * n];
        check_dig2 = new boolean[2 * n];

        System.out.print(go(0));
    }
}