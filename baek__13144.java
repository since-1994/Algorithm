import java.io.*;
import java.util.*;

class baek__13144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        boolean[] contain = new boolean[100001];
        long[] number_of_cases = new long[n + 1];
        number_of_cases[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            number_of_cases[i] = number_of_cases[i - 1] + i;
        }

        long answer = 0;

        int p1 = 0;
        int p2 = -1;
        int p3 = 0;
        contain[arr[p1]] = true;

        while (p3 < arr.length) {
            if (p3 + 1 < arr.length && contain[arr[p3 + 1]]) {
                answer += number_of_cases[p3 - p1 + 1] - number_of_cases[p2 - p1 + 1];
                p2 = p3;
                contain[arr[p1]] = false;
                p1++;
            } else {
                p3++;
                if (p3 < arr.length)
                    contain[arr[p3]] = true;
            }
        }

        answer += number_of_cases[arr.length - p1] - number_of_cases[p2 - p1 + 1];

        System.out.print(answer);
    }
}
