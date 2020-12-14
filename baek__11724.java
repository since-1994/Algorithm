import java.io.*;
import java.util.*;

class prob__11724 {

    static ArrayList<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        list = new ArrayList[n + 1];
        check = new boolean[n + 1];

        Arrays.fill(check, false);

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);

            list[from].add(to);
            list[to].add(from);
        }

        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            if (!check[i]) {
                answer++;
                dfs(i);
            }
        }

        System.out.print(answer);
    }

    static void dfs(int cur) {
        check[cur] = true;

        for (int next : list[cur]) {
            if (!check[next]) {
                dfs(next);
            }
        }
    }
}
