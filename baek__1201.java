import java.io.*;
import java.util.*;

class baek__1201 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int k = Integer.parseInt(temp[2]);

        if (m + k - 1 > n) {
            System.out.print(-1);
            return;
        }
        if (m * k < n) {
            System.out.print(-1);
            return;
        }

        int idx = 0;
        int[] index = new int[m];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        n -= k;
        index[idx++] = k; // k번째는 포함하지 말자.
        m -= 1;
        m = m == 0 ? 1 : m;

        int i = n / m; // 최초m이 1이었다면 방금 집합 만든걸로 끝났어야 한다. 그래서 i는 0이고 n도 0이다.
        int r = n % m;

        while (n > 0) {
            if (r > 0) {
                n -= 1 + i;
                r -= 1;
                index[idx] = index[idx - 1] + i + 1;
                idx++;
            } else {
                n -= i;
                index[idx] = index[idx - 1] + i;
                idx++;
            }
        }

        int[] answer = new int[arr.length];
        int idx_answer = 0;
        Stack<Integer> st = new Stack<>();

        for (int j = 0; j < index.length; j++) {
            if (j == 0) {
                for (int a = 0; a < index[j]; a++) {
                    st.add(arr[a]);
                }
                while (!st.isEmpty()) {
                    answer[idx_answer++] = st.pop();
                }
            } else {
                for (int a = index[j - 1]; a < index[j]; a++) {
                    st.add(arr[a]);
                }
                while (!st.isEmpty()) {
                    answer[idx_answer++] = st.pop();
                }
            }
        }

        for (int item : answer) {
            System.out.print(item + " ");
        }
        System.out.println();

    }
}