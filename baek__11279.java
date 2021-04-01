// import java.io.*;
// import java.util.*;

// class CustomComparator implements Comparator<Integer> {
// public int compare(Integer u, Integer v) {
// int a = Math.abs(u);
// int b = Math.abs(v);

// if (a < b) {
// return -1;
// } else if (a == b) {
// return u.compareTo(v);
// }
// return 1;
// }
// }

// class baek__11279 {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());

// PriorityQueue<Integer> q = new PriorityQueue<Integer>(1, new
// CustomComparator());

// StringBuilder sb = new StringBuilder();
// while (n-- > 0) {
// int number = Integer.parseInt(br.readLine());
// if (number == 0) {
// if (q.isEmpty())
// sb.append(0 + "\n");
// else
// sb.append(q.poll() + "\n");
// } else {
// q.add(number);
// }
// }
// System.out.print(sb);
// }
// }
