import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture> {
    int p;
    int d;

    Lecture(int p, int d) {
        this.p = p;
        this.d = d;
    }

    public int compareTo(Lecture that) {
        if (this.d > that.d) {
            return -1;
        } else if (this.d == that.d) {
            if (this.p > that.p) {
                return -1;
            } else {
                return 1;
            }
        }
        return 1;

    }
}

class baek__2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Lecture> lectures = new ArrayList<>();

        String[] temp;
        int biggestDay = 1;

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            int p = Integer.parseInt(temp[0]);
            int d = Integer.parseInt(temp[1]);

            lectures.add(new Lecture(p, d));
            biggestDay = Math.max(biggestDay, d);
        }

        for (int i = 1; i <= biggestDay; i++) {
            lectures.add(new Lecture(-1, i));
        }

        Collections.sort(lectures);
        PriorityQueue<Integer> values = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < lectures.size(); i++) {
            Lecture cur = lectures.get(i);

            if (cur.p == -1) {
                if (!values.isEmpty()) {
                    answer += values.poll();
                }
            } else {
                values.add(cur.p);
            }
        }

        System.out.print(answer);
    }
}