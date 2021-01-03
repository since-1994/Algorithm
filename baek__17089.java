import java.io.*;
import java.util.*;

class baek__17089 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        ArrayList<Integer>[] list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);

            list[from].add(to);
            list[to].add(from);
        }

        int ans = -1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (list[i].contains(j)) {
                    for (int k = j + 1; k < n + 1; k++) {
                        if (list[i].contains(k) && list[j].contains(k)) {
                            int result = list[i].size() + list[j].size() + list[k].size() - 6;
                            ans = ans == -1 ? result : Math.min(result, ans);
                        }
                    }
                }
            }
        }

        System.out.print(ans);
    }
}