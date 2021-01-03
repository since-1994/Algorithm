import java.io.*;
import java.util.*;

class Word {
    char start;
    char end;

    Word(char start, char end) {
        this.start = start;
        this.end = end;
    }
}

class baek__a {

    static Word[] words;

    static boolean go(int cnt, int end, boolean[] check) {
        if (cnt == check.length) {
            return true;
        }

        for (int i = 0; i < check.length; i++) {
            if (!check[i] && words[i].start == end) {
                check[i] = true;
                if (go(cnt + 1, words[i].end, check))
                    return true;
                check[i] = false;
            }
        }

        return false;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        words = new Word[n];

        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            char start = temp[i].charAt(0);
            char end = temp[i].charAt(temp[i].length() - 1);
            words[i] = new Word(start, end);
        }

        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(check, false);
            check[i] = true;
            if (go(1, words[i].end, check)) {
                System.out.print(1);
                return;
            }
        }

        System.out.print(0);
    }
}