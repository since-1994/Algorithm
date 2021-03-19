import java.io.*;
import java.util.*;

class baek__6549 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = 0;

        while (true) {
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            if (n == 0)
                break;

            int[] building = new int[n];
            for (int i = 0; i < n; i++) {
                building[i] = Integer.parseInt(temp[i + 1]);
            }

            Stack<Integer> st = new Stack<>();

            answer = 0;
            for (int i = 0; i < n; i++) {
                if (st.isEmpty())
                    st.push(i);
                else {
                    if (building[st.peek()] <= building[i]) {
                        st.push(i);
                    } else {
                        int right = i - 1;
                        int height = building[st.pop()];
                        int left = st.isEmpty() ? 0 : st.peek() + 1;
                        answer = Math.max(answer, (long) (right - left + 1) * height);
                        while (!st.isEmpty() && building[st.peek()] > building[i]) {
                            height = building[st.pop()];
                            left = st.isEmpty() ? 0 : st.peek() + 1;
                            answer = Math.max(answer, (long) (right - left + 1) * height);
                        }
                        st.push(i);
                    }
                }
            }

            int right = n - 1;
            while (!st.isEmpty()) {
                int height = building[st.pop()];
                int left = st.isEmpty() ? 0 : st.peek() + 1;
                answer = Math.max(answer, (right - left + 1) * (long) height);
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb);
    }
}