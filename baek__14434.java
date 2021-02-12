import java.io.*;
import java.util.*;

class baek__14434 {
    static int n;
    static int m;
    static int k;
    static int q;

    static int[] limit;
    static ArrayList<Integer>[] list;

    static int find(int day, int child1) {
        int l = -1;
        int r = list[child1].size();

        while (l + 1 < r) {
            int mid = (l + r) / 2;

            if (list[child1].get(mid) <= day) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l + 1;
    }

    static boolean check(int day, int child1, int child2, int ride) {

        int height1 = find(day, child1);
        int height2 = find(day, child2);

        if (height1 + height2 >= limit[ride - 1]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        k = Integer.parseInt(temp[2]);
        q = Integer.parseInt(temp[3]);

        temp = br.readLine().split(" ");
        limit = new int[m];

        for (int i = 0; i < m; i++) {
            limit[i] = Integer.parseInt(temp[i]);
        }
        list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        temp = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            list[Integer.parseInt(temp[i])].add(i);
        }
        int[] answer = new int[k];

        for (int i = 0; i < q; i++) {
            temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);
            int ride = Integer.parseInt(temp[2]);

            int l = -1;
            int r = k;

            while (l + 1 < r) {
                int mid = (l + r) / 2;

                if (check(mid, u, v, ride)) {
                    r = mid;
                } else {
                    l = mid;
                }
            }

            if (r == k)
                continue;
            answer[r] += 1;
        }

        for (int i = 1; i < k; i++) {
            answer[i] += answer[i - 1];
        }

        for (int i = 0; i < k; i++) {
            System.out.println(answer[i]);
        }

    }
}
