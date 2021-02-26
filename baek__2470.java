// import java.io.*;
// import java.util.*;

// class Pair {
// int i;
// int j;
// int val;

// Pair(int i, int j, int val) {
// this.i = i;
// this.j = j;
// this.val = val;
// }
// }

// class baek__2470 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// int[] arr = new int[n];

// String[] temp = br.readLine().split(" ");
// for (int i = 0; i < n; i++) {
// arr[i] = Integer.parseInt(temp[i]);
// }

// Arrays.sort(arr);

// int p1 = 0;
// int p2 = arr.length - 1;
// Pair pair = new Pair(-1, -1, -1);

// int sum = arr[p1] + arr[p2];
// pair.i = p1;
// pair.j = p2;
// pair.val = sum;

// while (p1 < p2) {
// if (Math.abs(sum) < Math.abs(pair.val)) {
// pair.i = p1;
// pair.j = p2;
// pair.val = sum;
// }

// if (sum > 0) {
// sum -= arr[p2];
// p2--;
// sum += arr[p2];
// } else if (sum == 0) {
// break;
// } else {
// sum -= arr[p1];
// p1++;
// sum += arr[p1];
// }
// }

// System.out.print(arr[pair.i] + " " + arr[pair.j]);
// }
// }
