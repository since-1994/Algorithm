import java.io.*;
import java.util.*;

class baek__9019 {

    static int[] from;
    static char[] how;

    static char[] ops = { 'D', 'S', 'L', 'R' };
    static StringBuilder sb = new StringBuilder();

    static void printReverse(int start, int end) {
        if (start == end) {
            return;
        }
        printReverse(start, from[end]);
        sb.append(how[end]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCase = Integer.parseInt(br.readLine());

        while (numberOfCase-- > 0) {
            String[] temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);

            from = new int[10001];
            how = new char[10001];

            Arrays.fill(from, -1);

            Queue<Integer> q = new LinkedList<>();

            q.add(start);
            from[start] = start;

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (char op : ops) {
                    if (op == 'D') {
                        int nex = cur * 2;
                        if (nex > 9999) {
                            nex /= 10000;
                        }
                        if (from[nex] != -1)
                            continue;

                        from[nex] = cur;
                        how[nex] = op;
                        q.add(nex);
                    } else if (op == 'S') {
                        int nex = cur - 1;
                        if (nex == -1)
                            nex = 9999;
                        if (from[nex] != -1)
                            continue;
                        from[nex] = cur;
                        how[nex] = op;
                        q.add(nex);
                    } else if (op == 'L') {
                        int nex = (cur % 1000) * 10 + cur / 1000;
                        if (from[nex] != -1)
                            continue;
                        from[nex] = cur;
                        how[nex] = op;
                        q.add(nex);
                    } else if (op == 'R') {
                        int nex = cur / 10 + (cur % 10) * 1000;
                        if (from[nex] != -1)
                            continue;
                        from[nex] = cur;
                        how[nex] = op;
                        q.add(nex);
                    }
                }
            }

            printReverse(start, end);
            sb.append('\n');
        }

        System.out.print(sb);
    }
}