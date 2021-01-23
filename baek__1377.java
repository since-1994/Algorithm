// import java.io.*;
// import java.util.*;

// class Point implements Comparable<Point> {
// int x;
// int before;

// Point(int x, int before) {
// this.x = x;
// this.before = before;
// }

// public int compareTo(Point that) {
// if (this.x < that.x)
// return -1;
// else if (this.x == that.x)
// return 0;
// else
// return 1;
// }
// }

// class baek__1377 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int n = Integer.parseInt(br.readLine());

// Point[] arr = new Point[n];

// for (int i = 0; i < n; i++) {
// arr[i] = new Point(Integer.parseInt(br.readLine()), i);
// }

// Arrays.sort(arr);

// int cnt = 0;

// for (int i = 0; i < n; i++) {
// if (i < arr[i].before) {
// cnt = Math.max(cnt, (arr[i].before - i));
// }
// }

// System.out.print(cnt + 1);
// }
// }

import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int x;
    int idx;

    Pair(int x, int idx) {
        this.x = x;
        this.idx = idx;
    }

    public int compareTo(Pair that) {
        if (this.x < that.x)
            return -1;
        else if (this.x == that.x)
            return 0;
        return 1;
    }
}

class baek__1377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Pair[] nums = new Pair[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new Pair(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(nums);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i < nums[i].idx) {
                cnt = Math.max(cnt, nums[i].idx - i);
            }
        }
        System.out.print(cnt + 1);
    }
}