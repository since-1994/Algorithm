import java.io.*;
import java.util.*;

class Pair {
    boolean isPossible;
    int answer;

    Pair(boolean isPossible, int answer) {
        this.isPossible = isPossible;
        this.answer = answer;
    }
}

class baek__2138 {

    static void flip(int[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < arr.length) {
                arr[i] = 1 - arr[i];
            }
        }
    }

    static Pair simul(int[] a, int[] b) {
        int n = a.length;
        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] != b[i]) {
                answer++;
                flip(a, i + 1);
            }
        }

        if (a[n - 1] != b[n - 1])
            return new Pair(false, answer);

        return new Pair(true, answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] now = new int[n];
        int[] target = new int[n];

        char[] temp = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            now[i] = temp[i] - '0';
        }
        temp = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            target[i] = temp[i] - '0';
        }

        int[] now1 = now.clone();
        int[] now2 = now.clone();
        flip(now2, 0);

        Pair answer1 = simul(now1, target);
        Pair answer2 = simul(now2, target);
        answer2.answer++;

        int answer = -1;

        if (answer1.isPossible && answer2.isPossible) {
            answer = Math.min(answer1.answer, answer2.answer);
        } else if (answer1.isPossible) {
            answer = answer1.answer;
        } else if (answer2.isPossible) {
            answer = answer2.answer;
        }

        System.out.print(answer);
    }
}