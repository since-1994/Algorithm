import java.io.*;
import java.util.*;

class baek__b {

    static String[] words;

    static int calc(int idx1, int idx2, int idx3) {
        int distance = 0;

        for (int i = 0; i < 4; i++) {
            if (words[idx1].charAt(i) != words[idx2].charAt(i)) {
                distance++;
            }
            if (words[idx1].charAt(i) != words[idx3].charAt(i)) {
                distance++;
            }
            if (words[idx2].charAt(i) != words[idx3].charAt(i)) {
                distance++;
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            words = br.readLine().split(" ");
            Arrays.sort(words);
            for (int i = 0; i < words.length; i++) {
                sb.append(words[i] + " ");
            }
            sb.append("\n");
            int ans = 12;

            for (int i = 0; i < words.length - 2; i++) {
                ans = Math.min(ans, calc(i, i + 1, i + 2));
            }

            sb.append(ans + "\n");
        }
        System.out.print(sb);
    }
}