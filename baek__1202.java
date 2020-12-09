import java.io.*;
import java.util.*;

class Parcel implements Comparable<Parcel> {
    int m;
    int v;

    Parcel(int m, int v) {
        this.m = m;
        this.v = v;
    }

    public int compareTo(Parcel that) {
        if (this.m < that.m)
            return -1;
        else if (this.m == that.m)
            return 0;
        return 1;

    }
}

class baek__1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        Parcel[] parcels = new Parcel[n + k];
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            int m = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);

            parcels[i] = new Parcel(m, v);
        }

        for (int i = n; i < n + k; i++) {
            int m = Integer.parseInt(br.readLine());
            int v = -1;
            parcels[i] = new Parcel(m, v);
        }

        long answer = 0;

        Arrays.sort(parcels);
        PriorityQueue<Integer> values = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < parcels.length; i++) {
            Parcel cur = parcels[i];
            if (cur.v == -1) {
                Integer value = values.poll();
                if (value != null) {
                    answer += value;
                }
            } else {
                values.add(cur.v);
            }
        }

        System.out.print(answer);
    }
}