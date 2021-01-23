// import java.io.*;
// import java.util.*;

// class baek__2343 {

// static void shuffle(int[] arr) {
// Random random = new Random();

// for (int i = arr.length - 1; i > 0; i--) {
// int index = random.nextInt(i + 1);
// int temp = arr[index];
// arr[index] = arr[i];
// arr[i] = temp;
// }
// }

// static int calc(int[] arr, int len) {

// int cnt = 0;
// int now = 0;

// for (int i = 0; i < arr.length; i++) {
// if (now + arr[i] > len) {
// cnt++;
// now = 0;
// }
// now += arr[i];
// }

// if (now != 0) {
// cnt++;
// }

// return cnt;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");
// int n = Integer.parseInt(temp[0]);
// int m = Integer.parseInt(temp[1]);

// int[] lessons = new int[n];
// temp = br.readLine().split(" ");
// int left = -1;
// int right = 0;

// for (int i = 0; i < n; i++) {
// lessons[i] = Integer.parseInt(temp[i]);

// right += lessons[i];
// if (left == -1) {
// left = lessons[i];
// } else {
// left = Math.max(left, lessons[i]);
// }
// }

// int ans = -1;

// while (left <= right) {
// int mid = (left + right) / 2;
// if (calc(lessons, mid) > m) {
// left = mid + 1;
// } else {
// ans = mid;
// right = mid - 1;
// }
// }

// System.out.print(ans);
// }
// }
import java.io.*;
import java.util.*;

class baek__2343 {
    static int MAX = 10000;
    static int n;
    static int m;
    static int[] courses;

    static boolean possible(int limit) {
        int now = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (limit < courses[i]) {
                return false;
            }
            now += courses[i];
            if (now > limit) {
                now = 0;
                now = courses[i];
                cnt++;
            } else if (now == limit) {
                now = 0;
                cnt++;
            }
        }

        if (now > 0) {
            cnt++;
        }
        if (cnt <= m)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        courses = new int[n];

        temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            courses[i] = Integer.parseInt(temp[i]);
        }

        int l = 0;
        int r = MAX * m;

        int ans = r;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (possible(mid)) {
                r = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                l = mid + 1;
            }
        }

        System.out.print(ans);
    }
}