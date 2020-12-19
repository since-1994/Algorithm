// import java.io.*;
// import java.util.*;

// class Point {
// int x;
// int y;

// Point(int x, int y) {
// this.x = x;
// this.y = y;
// }
// }

// class comparator implements Comparator<Point> {

// public int compare(Point a, Point b) {
// if (a.y < b.y) {
// return -1;
// } else if (a.y == b.y) {
// if (a.x < b.x) {
// return -1;
// } else if (a.x == b.x) {
// return 0;
// } else {
// return 1;
// }
// } else {
// return 1;
// }
// }
// }

// class baek__11651 {

// static void shuffle(Point[] arr) {
// Random random = new Random();

// for (int i = arr.length - 1; i > 0; i--) {
// int index = random.nextInt(i + 1);
// Point temp = arr[index];
// arr[index] = arr[i];
// arr[i] = temp;
// }
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());
// Point[] points = new Point[n];

// String[] temp;
// for (int i = 0; i < n; i++) {
// temp = br.readLine().split(" ");
// int x = Integer.parseInt(temp[0]);
// int y = Integer.parseInt(temp[1]);

// points[i] = new Point(x, y);
// }

// shuffle(points);
// Arrays.sort(points, new comparator());

// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < n; i++) {
// sb.append(points[i].x + " " + points[i].y + "\n");
// }

// System.out.print(sb);
// }
// }