import java.io.*;
import java.util.*;

class baek__14697 {

    static int[] dx = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < 3; i++) {
            dx[i] = Integer.parseInt(temp[i]);
        }

        int n = Integer.parseInt(temp[3]);

        boolean[] check = new boolean[301];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            q.add(dx[i]);
            check[dx[i]] = true;
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int k = 0; k < 3; k++) {
                int nx = x + dx[k];
                if (nx > n)
                    continue;
                if (check[nx])
                    continue;
                q.add(nx);
                check[nx] = true;
            }
        }

        System.out.print(check[n] ? 1 : 0);

    }
}
