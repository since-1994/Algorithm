import java.io.*;
import java.util.*;

public class code__704__2 {

    static int getMax(boolean[] used) {
        for (int i = used.length - 1; i >= 1; i--) {
            if (!used[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        String[] temp;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] cards = new int[n];
            ArrayList<Integer> list = new ArrayList<>();
            temp = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                cards[i] = Integer.parseInt(temp[i]);
            }

            ArrayList<String> beforeUsed = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                beforeUsed.add(Integer.toString(i));
            }
            int max = Integer.parseInt(beforeUsed.get(beforeUsed.size() - 1));
            Queue<Integer> q = new LinkedList<>();
            for (int i = cards.length - 1; i >= 0; i--) {
                if (cards[i] == max) {
                    q.add(i);
                    beforeUsed.remove(Integer.toString(cards[i]));
                    if (i != 0)
                        max = Integer.parseInt(beforeUsed.get(beforeUsed.size() - 1));
                } else {
                    beforeUsed.remove(Integer.toString(cards[i]));

                }
            }

            int end = cards.length - 1;
            while (!q.isEmpty()) {
                for (int i = q.peek(); i <= end; i++) {
                    sb.append(cards[i] + " ");
                }
                end = q.poll() - 1;
            }
            sb.append("\n");

        }

        System.out.print(sb);

    }
}
