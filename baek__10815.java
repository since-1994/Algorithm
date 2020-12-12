import java.io.*;
import java.util.*;

class baek__10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(card);

        int m = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(temp[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            int start = 0;
            int end = n - 1;

            boolean isRight = false;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (card[mid] == target) {
                    isRight = true;
                    break;
                } else if (card[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            sb.append(isRight ? "1 " : "0 ");
        }

        System.out.print(sb);
    }
}