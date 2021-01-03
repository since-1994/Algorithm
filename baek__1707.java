import java.io.*;
import java.util.*;

class baek__1707 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            int[] group = new int[v + 1];
            boolean isRight = true;

            ArrayList<Integer>[] list = new ArrayList[v + 1];

            for (int i = 0; i < v + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                list[from].add(to);
                list[to].add(from);
            }

            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i < v + 1; i++) {
                if (group[i] == 0) {
                    group[i] = 1;
                    q.add(i);
                    while (!q.isEmpty()) {
                        int cur = q.poll();
                        for (int nex : list[cur]) {
                            if (group[nex] != 0 && group[nex] == group[cur]) {
                                isRight = false;
                            } else if (group[nex] == 0) {
                                group[nex] = 3 - group[cur];
                                q.add(nex);
                            }
                        }
                    }
                }
            }

            sb.append(isRight ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
}