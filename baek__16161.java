// import java.io.*;
// import java.util.*;
// // 요거는 solved 아니니 주의하시게
// class baek__16161 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// int[] arr = new int[n + 1];
// String[] temp = br.readLine().split(" ");

// for (int i = 0; i < n; i++) {
// arr[i] = Integer.parseInt(temp[i]);
// }
// arr[n] = 1000000001;

// int ans = 1;
// int p = 0;
// int c1 = 0;
// int c2 = 0;

// while (p < n) {
// if (arr[p] < arr[p + 1]) {
// p++;
// c1 = c2 = p;
// } else if (arr[p] == arr[p + 1]) {
// p++;
// c2 = p;
// ans = Math.max(ans, c2 - c1 + 1);
// } else {
// if (c1 - (p + 1 - c2) >= 0 && arr[c1 - (p + 1 - c2)] == arr[p + 1]) {
// p++;
// ans = Math.max(ans, (p - c2) * 2 + c2 - c1 + 1);
// } else {
// p++;
// }
// }
// }

// System.out.print(ans);

// }
// }
