import java.io.*;
import java.util.*;

class baek__1043 {

    static void dfs(int now, boolean[] check, ArrayList<Integer>[] list) {
        check[now] = true;

        for (int next : list[now]) {
            if (check[next])
                continue;
            dfs(next, check, list);
        }
    }

    static boolean possible_to_lie(ArrayList<Integer> participants, boolean[] check) {

        for (int participant : participants) {
            if (check[participant])
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        ArrayList<Integer> intellectual = new ArrayList<>();

        temp = br.readLine().split(" ");

        int o = Integer.parseInt(temp[0]);

        for (int i = 1; i < o + 1; i++) {
            intellectual.add(Integer.parseInt(temp[i]));
        }

        ArrayList<Integer>[] nodes = new ArrayList[51];
        ArrayList<Integer>[] participants = new ArrayList[51];

        for (int i = 1; i < 51; i++) {
            nodes[i] = new ArrayList<>();
            participants[i] = new ArrayList<>();
        }

        for (int i = 1; i < m + 1; i++) {
            temp = br.readLine().split(" ");

            int party_size = Integer.parseInt(temp[0]);

            for (int k = 1; k < party_size + 1; k++) {
                participants[i].add(Integer.parseInt(temp[k]));
            }

            for (int u : participants[i]) {
                for (int v : participants[i]) {
                    if (u == v)
                        continue;
                    nodes[u].add(v);
                    nodes[v].add(u);
                }
            }
        }

        boolean[] check = new boolean[n + 1];

        for (int start : intellectual) {
            if (check[start])
                continue;
            dfs(start, check, nodes);
        }

        int answer = 0;

        for (int i = 1; i < m + 1; i++) {
            if (possible_to_lie(participants[i], check))
                answer++;
        }

        System.out.print(answer);
    }
}
