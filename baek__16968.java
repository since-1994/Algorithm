import java.io.*;
import java.util.*;

class baek__16968 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'c') {
                if (i == 0)
                    ans[i] = 26;
                else if (arr[i - 1] == 'c')
                    ans[i] = 25;
                else
                    ans[i] = 26;
            } else {
                if (i == 0)
                    ans[i] = 10;
                else if (arr[i - 1] == 'd')
                    ans[i] = 9;
                else
                    ans[i] = 10;
            }
        }

        int cnt = 1;

        for (int i = 0; i < ans.length; i++) {
            cnt *= ans[i];
        }

        System.out.print(cnt);
    }
}