// import java.io.*;
// import java.util.*;

// class Num implements Comparable<Num> {
// long value;
// int number_of_3;

// Num(long value, int number) {
// this.value = value;
// this.number_of_3 = number;
// }

// public int compareTo(Num that) {
// if (this.number_of_3 > that.number_of_3) {
// return -1;
// } else if (this.number_of_3 == that.number_of_3) {
// return this.value < that.value ? -1 : 1;
// } else {
// return 1;
// }
// }
// }

// class baek__16936 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// String[] temp = br.readLine().split(" ");

// Num[] b = new Num[n];
// for (int i = 0; i < n; i++) {
// b[i] = new Num(Long.parseLong(temp[i]), 0);
// long num = Long.parseLong(temp[i]);
// while (num >= 3) {
// if (num % 3 == 0) {
// num /= 3;
// b[i].number_of_3 += 1;
// } else {
// break;
// }
// }
// }

// Arrays.sort(b);

// for (int i = 0; i < n; i++) {
// System.out.print(b[i].value + " ");
// }

// }
// }