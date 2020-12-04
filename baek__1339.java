import java.io.*;
import java.util.*;

class baek__1339 {

    static int[] ascii = new int[256];
    static Character[] letters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashSet<Character> alphaSet = new HashSet<>();
        String[] words = new String[n];
        Arrays.fill(ascii, 0);

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            words[i] = s;
            for (char c : s.toCharArray()) {
                alphaSet.add(c);
            }
        }

        letters = alphaSet.toArray(new Character[alphaSet.size()]);
        int[] d = new int[letters.length];

        for (int i = 0; i < d.length; i++) {
            d[i] = 9 - i;
        }

        Arrays.sort(d);
        int max = 0;

        do {
            max = Math.max(max, result_of_simul(d, words));
        } while (next_permutation(d));

        System.out.print(max);
    }

    static boolean next_permutation(int[] arr) {
        int start = -1;
        int k = arr.length;

        for (int i = k - 1; i >= 1; i--) {
            if (arr[i - 1] < arr[i]) {
                start = i - 1;
                break;
            }
        }

        if (start == -1)
            return false;

        for (int i = k - 1; i > start; i--) {
            if (arr[start] < arr[i]) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        start++;
        int end = k - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return true;
    }

    static int result_of_simul(int[] d, String[] words) {
        int sum = 0;
        for (int i = 0; i < letters.length; i++) {
            ascii[letters[i]] = d[i];
        }

        for (int i = 0; i < words.length; i++) {
            int temp = 0;
            for (char c : words[i].toCharArray()) {
                temp = temp * 10 + ascii[c];
            }
            sum += temp;
        }

        return sum;
    }
}