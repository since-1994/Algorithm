import java.io.*;
import java.util.*;

class baek__1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> card_size = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            card_size.add(Integer.parseInt(br.readLine()));
        }

        if (n == 1) {
            System.out.print(0);
            return;
        }

        int answer = 0;

        while (true) {
            int now = card_size.poll() + card_size.poll();
            answer += now;
            card_size.add(now);
            if (card_size.size() == 1)
                break;
        }

        System.out.print(answer);
    }
}
