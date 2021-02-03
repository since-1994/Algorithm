import java.io.*;
import java.util.*;

class baek__1655 {
    static class Custom implements Comparator<Integer> {
        public int compare(Integer u, Integer v) {
            if (u < v) {
                return 1;
            } else if (u == v) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> l = new PriorityQueue<>(1, new Custom());
        PriorityQueue<Integer> r = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (!l.isEmpty() && l.peek() > num) {
                l.add(num);
            } else if (!r.isEmpty() && r.peek() < num) {
                r.add(num);
            } else {
                l.add(num);
            }

            if (r.size() > l.size()) {
                l.add(r.poll());
            } else if (l.size() - r.size() >= 2) {
                r.add(l.poll());
            }

            sb.append(l.peek() + "\n");
        }

        System.out.print(sb);
    }
}