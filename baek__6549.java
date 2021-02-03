import java.io.*;
import java.util.*;

class baek__6549 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] temp = br.readLine().split(" ");

            int n = Integer.parseInt(temp[0]);

            if (n == 0)
                break;

            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(temp[i + 1]);
            }

            Stack<Integer> stack = new Stack<>();
            long answer = 0;

            for (int i = 0; i < n; i++) {
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    if (heights[stack.peek()] <= heights[i]) {
                        stack.push(i);
                    } else {
                        while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                            int h = heights[stack.pop()];
                            int right = i - 1;
                            int left = 0;
                            if (!stack.empty())
                                left = stack.peek() + 1;
                            long area = (long) (right - left + 1) * h;
                            answer = Math.max(area, answer);
                        }
                        stack.push(i);
                    }
                }
            }
            int right = stack.peek();

            while (!stack.empty()) {
                int h = heights[stack.pop()];
                int left = 0;
                if (!stack.empty())
                    left = stack.peek() + 1;
                long area = (long) (right - left + 1) * h;
                answer = Math.max(area, answer);
            }

            sb.append(answer + "\n");
        }
        System.out.print(sb);
    }
}