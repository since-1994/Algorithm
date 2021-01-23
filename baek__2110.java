// import java.io.*;
// import java.util.*;

// class baek__2110 {

// static void shuffle(int[] arr) {
// Random random = new Random();

// for (int i = arr.length - 1; i > 0; i--) {
// int index = random.nextInt(i + 1);
// int temp = arr[i];
// arr[i] = arr[index];
// arr[index] = temp;
// }
// }

// static int calc(int[] arr, int space) {

// int last = 0;
// int cnt = 1;

// for (int i = 1; i < arr.length; i++) {
// if (arr[i] - arr[last] >= space) {
// cnt++;
// last = i;
// }
// }

// return cnt;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int c = Integer.parseInt(temp[1]);
// int[] houses = new int[n];

// for (int i = 0; i < n; i++) {
// houses[i] = Integer.parseInt(br.readLine());
// }

// shuffle(houses);
// Arrays.sort(houses);

// int start = 1;
// int end = houses[houses.length - 1] - houses[0];
// int ans = 0;

// while (start <= end) {
// int mid = (start + end) / 2;
// if (calc(houses, mid) < c) {
// end = mid - 1;
// } else {
// ans = mid;
// start = mid + 1;
// }
// }

// System.out.print(ans);

// }
// }

import java.io.*;
import java.util.*;

class baek__2110 {
    static int n;
    static int c;
    static int[] houses;

    static boolean check(int diff) {
        int cnt = 0;
        int lastC = houses[0];
        cnt++;

        for (int i = 0; i < n; i++) {
            if (houses[i] - lastC >= diff) {
                cnt++;
                lastC = houses[i];
            }
        }

        if (cnt >= c)
            return true;

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        c = Integer.parseInt(temp[1]);

        houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);
        int ans = 0;
        int l = 0;
        int r = houses[houses.length - 1] - houses[0];

        while (l <= r) {
            int mid = (l + r) / 2;

            if (check(mid)) {
                l = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                r = mid - 1;
            }
        }

        System.out.print(ans);
    }
}