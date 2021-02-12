// import java.io.*;
// import java.util.*;

// class Pair implements Comparable<Pair> {
// long value;
// int idx;

// Pair(long value, int idx) {
// this.value = value;
// this.idx = idx;
// }

// public int compareTo(Pair that) {
// if (this.value < that.value) {
// return -1;
// } else if (this.value == that.value) {
// Integer u = this.idx;
// Integer v = that.idx;
// return u.compareTo(v);
// }
// return 1;
// }
// }

// class baek__16210 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// Pair[] x = new Pair[n];
// Pair[] y = new Pair[n];
// Pair[] dist = new Pair[n];

// String[] temp;
// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// x[i] = new Pair(Integer.parseInt(temp[0]), i);
// y[i] = new Pair(Integer.parseInt(temp[1]), i);
// dist[i] = new Pair(0, i);
// }

// Arrays.sort(x);
// Arrays.sort(y);

// long[] sumXarr = new long[n];
// long[] sumYarr = new long[n];

// long sumX = 0;
// long sumY = 0;

// for (int i = 0; i < n; i++) {
// sumX += x[i].value;
// sumY += y[i].value;
// sumXarr[i] = sumX;
// sumYarr[i] = sumY;
// }

// dist[x[0].idx].value += sumXarr[n - 1] - sumXarr[0] - x[0].value * (n - 1);
// dist[y[0].idx].value += sumYarr[n - 1] - sumYarr[0] - y[0].value * (n - 1);

// for (int i = 1; i < n; i++) {
// dist[x[i].idx].value += (sumXarr[n - 1] - sumXarr[i] - x[i].value * (n - 1 -
// i))
// + (x[i].value * i - sumXarr[i - 1]);
// dist[y[i].idx].value += (sumYarr[n - 1] - sumYarr[i] - y[i].value * (n - 1 -
// i))
// + (y[i].value * i - sumYarr[i - 1]);
// }

// Arrays.sort(dist);
// System.out.print(dist[0].idx + 1);
// }
// }
