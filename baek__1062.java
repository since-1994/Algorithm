import java.io.*;
import java.util.*;

class baek__1062 {

    static int[] words;

    static int count(int dict) {
        int cnt = 0;

        for (int i = 0; i < words.length; i++) {
            if ((words[i] & ((1 << 26) - 1 - dict)) == 0) {
                cnt += 1;
            }
        }

        return cnt;
    }

    static int go(int index, int k, int dict) {
        if (k < 0) {
            return 0;
        }
        if (index == 26) {
            return count(dict);
        }
        if (index == 'a' - 'a' || index == 'n' - 'a' || index == 't' - 'a' || index == 'i' - 'a' || index == 'c' - 'a')
            return go(index + 1, k, dict);
        int returnValue = Math.max(go(index + 1, k - 1, dict | (1 << index)), go(index + 1, k, dict));
        return returnValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        if (k < 5) {
            System.out.print(0);
            return;
        }

        words = new int[n];
        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            int word = 0;
            for (int j = 0; j < row.length; j++) {
                word |= (1 << (row[j] - 'a'));
            }
            words[i] = word;
        }

        int dict = 0;
        dict |= 1 << ('a' - 'a');
        dict |= 1 << ('n' - 'a');
        dict |= 1 << ('t' - 'a');
        dict |= 1 << ('i' - 'a');
        dict |= 1 << ('c' - 'a');

        System.out.print(go(0, k - 5, dict));
    }
}