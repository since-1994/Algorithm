// import java.io.*;
// import java.util.*;

// class baek__2022 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// String[] temp = br.readLine().split(" ");

// double x = Double.parseDouble(temp[0]);
// double y = Double.parseDouble(temp[1]);
// double c = Double.parseDouble(temp[2]);

// double l = 0;
// double r = Math.max(x, y);
// double d = 0;

// while (Math.abs(r - l) > 1e-3) {
// double mid = (r + l) / 2;
// double h1 = Math.sqrt(x * x - mid * mid);
// double h2 = Math.sqrt(y * y - mid * mid);
// double h = (h1 * h2) / (h1 + h2);

// if (h > c) {
// l = mid;
// } else {
// d = mid;
// r = mid;
// }
// }

// System.out.printf("%.3f", d);
// }
// }

import java.io.*;
import java.util.*;

class baek__2022 {
    static double x;
    static double y;
    static double c;

    static double calc(double d) {
        double h1 = Math.sqrt(x * x - d * d);
        double h2 = Math.sqrt(y * y - d * d);

        double ans = (h1 * h2) / (h1 + h2);

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        x = Double.parseDouble(temp[0]);
        y = Double.parseDouble(temp[1]);
        c = Double.parseDouble(temp[2]);

        double l = 0;
        double r = Math.min(x, y);
        double ans = 0;

        while (r - l >= 1e-6) {
            double mid = (l + r) / 2;

            if (calc(mid) - c <= 1e-6) {
                r = mid;
                ans = mid;
            } else {
                l = mid;
            }
        }

        System.out.printf("%.3f", ans);
    }
}