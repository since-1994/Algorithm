// import java.io.*;
// import java.util.*;

// class Pair {
// int min;
// int max;

// Pair(int min, int max) {
// this.min = min;
// this.max = max;
// }
// }

// class baek__20495 {

// static int lower_bound(int[] arr, int target) {
// int start = -1;
// int end = arr.length;

// while (start + 1 < end) {
// int mid = (start + end) / 2;

// if (arr[mid] >= target) {
// end = mid;
// } else {
// start = mid;
// }
// }

// return end;
// }

// static int upper_bound(int[] arr, int target) {
// int start = -1;
// int end = arr.length;

// while (start + 1 < end) {
// int mid = (start + end) / 2;

// if (arr[mid] > target) {
// end = mid;
// } else {
// start = mid;
// }
// }

// return end;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// String[] temp;
// Pair[] pairs = new Pair[n];

// int[] minArr = new int[n];
// int[] maxArr = new int[n];

// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");

// int x = Integer.parseInt(temp[0]);
// int dx = Integer.parseInt(temp[1]);

// pairs[i] = new Pair(x - dx, x + dx);
// minArr[i] = x - dx;
// maxArr[i] = x + dx;
// }

// Arrays.sort(minArr);
// Arrays.sort(maxArr);

// StringBuilder sb = new StringBuilder();

// for (int i = 0; i < n; i++) {
// sb.append((lower_bound(maxArr, pairs[i].min) + 1) + " ");
// sb.append((upper_bound(minArr, pairs[i].max) - 1 + 1) + "\n");
// }

// System.out.print(sb);
// }
// }
