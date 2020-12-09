import java.io.*;
import java.util.*;

class Node {
    int a;
    int b;

    Node(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class baek__12886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int sum = Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]) + Integer.parseInt(temp[2]);
        Node start = new Node(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));

        if (sum % 3 != 0) {
            System.out.print(0);
            return;
        }

        boolean[][] check = new boolean[sum + 1][sum + 1];
        Queue<Node> q = new LinkedList<>();

        check[start.a][start.b] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            int a = cur.a;
            int b = cur.b;
            int c = sum - a - b;

            int[] now = { a, b, c };

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (now[i] >= now[j])
                        continue;
                    int[] next = now.clone();
                    next[i] *= 2;
                    next[j] -= now[i];
                    if (check[next[0]][next[1]] == true)
                        continue;
                    q.add(new Node(next[0], next[1]));
                    check[next[0]][next[1]] = true;
                }
            }
        }

        System.out.print(check[sum / 3][sum / 3] ? 1 : 0);

    }
}