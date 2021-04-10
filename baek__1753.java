import java.io.*;
import java.util.*;

class baek__1753 {
    static int MAX = 200001;

    static class Node {
        int x;
        int w;

        Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int d;
        int idx;

        Pair(int d, int idx) {
            this.d = d;
            this.idx = idx;
        }

        public int compareTo(Pair that) {
            Integer u = this.d;
            Integer v = that.d;

            return u.compareTo(v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int v = Integer.parseInt(temp[0]);
        int e = Integer.parseInt(temp[1]);

        int root = Integer.parseInt(br.readLine());

        ArrayList<Node>[] list = new ArrayList[v + 1];

        for (int i = 1; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            temp = br.readLine().split(" ");

            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int k = Integer.parseInt(temp[2]);

            list[a].add(new Node(b, k));
        }

        int[] d = new int[v + 1];
        Arrays.fill(d, MAX);

        PriorityQueue<Pair> q = new PriorityQueue<>();
        d[root] = 0;
        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (now.d != d[now.idx])
                continue;

            for (Node nex : list[now.idx]) {
                if (d[nex.x] > d[now.idx] + nex.w) {
                    d[nex.x] = d[now.idx] + nex.w;
                    q.add(new Pair(d[nex.x], nex.x));
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            System.out.println(d[i] == MAX ? "INF" : d[i]);
        }
    }
}

// import java.util.ArrayList;
// import java.util.PriorityQueue;
// import java.util.Scanner;

// public class Main {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);

// int N = sc.nextInt();
// int E = sc.nextInt();
// int start = sc.nextInt();

// int[] distance = new int[N+1];
// ArrayList<ArrayList<int[]>> graph = new ArrayList<ArrayList<int[]>>();

// for(int i = 0; i < N+1; i++) {
// graph.add(new ArrayList<int[]>());
// distance[i] = 10000001;
// }

// for (int i = 0; i < E; i++) {
// int a = sc.nextInt();
// int[] b = {sc.nextInt(), sc.nextInt()};
// graph.get(a).add(b);
// }

// PriorityQueue<int[]> queue = new PriorityQueue<int[]>((int[] i1, int[] i2) ->
// i1[0] >= i2[0] ? 1 : -1);
// distance[start] = 0;
// queue.offer(new int[] {distance[start], start});

// while(queue.isEmpty()==false) {
// int[] poll = queue.poll();
// int dist = poll[0];
// int now = poll[1];

// for(int[] i : graph.get(poll[1])) {
// int cost = dist + i[1];
// if(cost < distance[i[0]]) {
// distance[i[0]] = cost;
// queue.offer(new int[] {cost, i[0]});
// }
// }
// }

// for (int i = 1; i < N+1; i++) {
// if(10000001<=distance[i]) {
// System.out.println("INF");
// }else {
// System.out.println(distance[i]);
// }
// }
// }
// }