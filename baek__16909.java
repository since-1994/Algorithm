import java.io.*;
import java.util.*;

class baek__16909 {
    static int[] a;

    static int[] minR;
    static int[] maxR;
    static int[] minL;
    static int[] maxL;

    static void findMin(Stack<Integer> stack, int i, boolean isRight) {

        while (!stack.empty() && a[stack.peek()] > a[i]) {
            int j = stack.pop();
            if (isRight)
                minR[j] = i - 1;
            else
                minL[j] = i + 1;
        }
        stack.push(i);

        if (isRight && i == a.length - 1) {
            while (!stack.empty()) {
                minR[stack.pop()] = a.length - 1;
            }
        } else if (!isRight && i == 0) {
            while (!stack.empty()) {
                minL[stack.pop()] = 0;
            }
        }
    }

    static void findMax(Stack<Integer> stack, int i, boolean isRight) {

        while (!stack.empty() && a[stack.peek()] < a[i]) {
            int j = stack.pop();
            if (isRight)
                maxR[j] = i - 1;
            else
                maxL[j] = i + 1;
        }
        stack.push(i);

        if (isRight && i == a.length - 1) {
            while (!stack.empty()) {
                maxR[stack.pop()] = a.length - 1;
            }
        } else if (!isRight && i == 0) {
            while (!stack.empty()) {
                maxL[stack.pop()] = 0;
            }
        }

    }

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
        maxR = new int[n];
        minL = new int[n];
        maxL = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(temp[i]);
        }

        Stack<Integer> stackMin = new Stack<>();
        Stack<Integer> stackMax = new Stack<>();

        for (int i = 0; i < n; i++) {
            findMin(stackMin, i, true);
            findMax(stackMax, i, true);
        }

        for (int i = n - 1; i >= 0; i--) {
            findMin(stackMin, i, false);
            findMax(stackMax, i, false);
        }

        long answer = 0;

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