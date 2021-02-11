import java.io.*;
import java.util.*;

class baek__16909 {
    static int[] a;

    static int[] minR;
    static int[] maxR;
    static int[] minL;
    static int[] maxL;

    static long calc(int n) {
        long returnValue = 1L * n * (n + 1) / 2;
        return returnValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        a = new int[n];
        minR = new int[n];
        Arrays.fill(minR, n - 1);
        maxR = new int[n];
        Arrays.fill(maxR, n - 1);
        minL = new int[n];
        Arrays.fill(minL, 0);
        maxL = new int[n];
        Arrays.fill(maxL, 0);

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(temp[i]);
        }

        Stack<Integer> stackMin = new Stack<>();
        Stack<Integer> stackMax = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stackMin.empty() && a[stackMin.peek()] >= a[i]) {
                minR[stackMin.pop()] = i - 1;
            }
            stackMin.push(i);

            while (!stackMax.empty() && a[stackMax.peek()] <= a[i]) {
                maxR[stackMax.pop()] = i - 1;
            }
            stackMax.push(i);
        }

        stackMin.clear();
        stackMax.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stackMin.empty() && a[stackMin.peek()] > a[i]) {
                minL[stackMin.pop()] = i + 1;
            }
            stackMin.push(i);

            while (!stackMax.empty() && a[stackMax.peek()] < a[i]) {
                maxL[stackMax.pop()] = i + 1;
            }
            stackMax.push(i);
        }

        long answer = 0;

        // for (int i = 0; i < n; i++) {
        // System.out.print(minL[i] + " ");
        // }
        // System.out.println();

        // for (int i = 0; i < n; i++) {
        // System.out.print(minR[i] + " ");
        // }
        // System.out.println();

        // for (int i = 0; i < n; i++) {
        // System.out.print(maxL[i] + " ");
        // }
        // System.out.println();

        // for (int i = 0; i < n; i++) {
        // System.out.print(maxR[i] + " ");
        // }
        // System.out.println();

        for (int i = 0; i < n; i++) {
            int l = maxL[i];
            int r = maxR[i];
            int len = r - l + 1;
            answer += (calc(len) - calc(r - i) - calc(i - l)) * a[i];

            l = minL[i];
            r = minR[i];
            len = r - l + 1;
            answer -= (calc(len) - calc(r - i) - calc(i - l)) * a[i];
        }

        System.out.print(answer);
    }
}