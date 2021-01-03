import java.io.*;
import java.util.*;

class baek__16964 {
    static ArrayList<Integer>[] list;
    static int[] answerFromMe;
    static int idx = 0;

    static void go(int now, boolean[] check) {
        if (check[now]) {
            return;
        }
        check[now] = true;
        answerFromMe[idx++] = now;

        for (int nex : list[now]) {
            go(nex, check);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        String[] temp;
        for (int i = 0; i < n - 1; i++) {
            temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);

            list[u].add(v);
            list[v].add(u);
        }
        int[] answerFromUser = new int[n];
        answerFromMe = new int[n];
        int[] priority = new int[n + 1];

        temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            answerFromUser[i] = Integer.parseInt(temp[i]);
            priority[answerFromUser[i]] = i;
        }

        Comparator<Integer> c = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (priority[a] < priority[b])
                    return -1;
                else if (priority[a] == priority[b])
                    return 0;
                else
                    return 1;
            }
        };

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i], c);
        }

        boolean[] check = new boolean[n + 1];
        go(answerFromUser[0], check);

        if (answerFromUser[0] != 1) {
            System.out.print(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (answerFromMe[i] != answerFromUser[i]) {
                System.out.print(0);
                return;
            }
        }
        System.out.print(1);
    }
}