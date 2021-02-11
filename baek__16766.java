import java.io.*;
import java.util.*;

class baek__16766 {
    static int MAX = 1000000000;
    static int n;
    static int m;
    static int c;
    static int[] arrival;

    static boolean check(int maxTime) {
        int bus = 0;
        int number_of_cow = 0;
        int arrivalTime = -1;

        for (int i = 0; i < n; i++) {
            if (arrivalTime == -1) {
                arrivalTime = arrival[i];
                number_of_cow++;
            } else if (arrival[i] - arrivalTime > maxTime) {
                bus++;
                number_of_cow = 1;
                arrivalTime = arrival[i];
            } else {
                number_of_cow++;
            }

            if (number_of_cow == c) {
                bus++;
                number_of_cow = 0;
                arrivalTime = -1;
            }
        }
        if (number_of_cow > 0) {
            bus++;
        }

        if (bus <= m) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        c = Integer.parseInt(temp[2]);

        arrival = new int[n];
        temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrival[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(arrival);

        int l = -1;
        int r = MAX + 1;

        while (l + 1 < r) {
            int mid = (l + r) / 2;

            if (check(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.print(r);

    }
}
