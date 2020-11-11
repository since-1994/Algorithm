import java.io.*;
import java.util.*;

class baek__1339 {

    static int[] alphabet = new int[26];
    static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        Arrays.fill(alphabet, 0);

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            for (char alpha : words[i].toCharArray()) {
                set.add(alpha - 'A');
            }
        }

        Integer[] alphabet__target = set.toArray(new Integer[set.size()]);

        value = new int[alphabet__target.length];
        for (int i = 0; i < value.length; i++) {
            alphabet[alphabet__target[i]] = i;
            value[i] = 9 - i;
        }

        Arrays.sort(value);
        int answer = 0;

        do {
            int cur = 0;
            for (int i = 0; i < words.length; i++) {
                cur += getValue(words[i]);
            }
            answer = Math.max(answer, cur);
        } while (next_permutation(value));

        System.out.print(answer);
    }

    static boolean next_permutation(int[] arr) {
        int start = -1;
        int n = arr.length;

        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                start = i - 1;
                break;
            }
        }

        if (start == -1)
            return false;

        for (int i = n - 1; i > start; i--) {
            if (arr[i] > arr[start]) {
                int temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
                break;
            }
        }

        start++;
        int end = n - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return true;
    }

    static int getValue(String word) {
        int returnValue = 0;

        for (char alpha : word.toCharArray()) {
            returnValue = returnValue * 10 + value[alphabet[alpha - 'A']];
        }

        return returnValue;
    }

}
