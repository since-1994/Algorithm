import java.io.*;
import java.util.*;

class baek__1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int now = Integer.parseInt(br.readLine());

            if (left.isEmpty()) {
                left.add(now);
            } else if (left.peek() > now) {
                left.add(now);

            } else {
                right.add(now);
                left.add(right.poll());
            }

            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            }

            sb.append(left.peek() + "\n");
        }

        System.out.print(sb);
    }
}