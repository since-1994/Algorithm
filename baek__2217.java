import java.io.*;
import java.util.*;

class baek__2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (!q.isEmpty()) {
            int min = q.poll();
            answer = Math.max(answer, min * (q.size() + 1));
        }
        System.out.print(answer);
    }
}
