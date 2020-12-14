import java.io.*;
import java.util.*;

class Consult {
    int day;
    int pay;

    Consult(int day, int pay) {
        this.day = day;
        this.pay = pay;
    }
}

// 다이나믹으로 풀어볼게요
class baek__14501 {
    static int n;
    static Consult[] consults;
    static int[] d;

    static int go(int day) {
        if (day == n) {
            return 0;
        } else if (day > n) {
            return -1;
        }

        if (d[day] != -1) {
            return d[day];
        }

        d[day] = Math.max(consults[day].pay + go(day + consults[day].day), go(day + 1));

        return d[day];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        consults = new Consult[n];
        d = new int[n];
        Arrays.fill(d, -1);

        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            consults[i] = new Consult(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        System.out.print(go(0));
    }
}