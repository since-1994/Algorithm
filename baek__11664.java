// import java.io.*;
// import java.util.*;

// class baek__11664 {

//     static double dist(double x1, double y1, double z1, double x2, double y2, double z2) {
//         return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         String[] temp = br.readLine().split(" ");
//         double x1 = Double.parseDouble(temp[0]);
//         double y1 = Double.parseDouble(temp[1]);
//         double z1 = Double.parseDouble(temp[2]);

//         double x2 = Double.parseDouble(temp[3]);
//         double y2 = Double.parseDouble(temp[4]);
//         double z2 = Double.parseDouble(temp[5]);

//         double x3 = Double.parseDouble(temp[6]);
//         double y3 = Double.parseDouble(temp[7]);
//         double z3 = Double.parseDouble(temp[8]);

//         double dx = x2 - x1;
//         double dy = y2 - y1;
//         double dz = z2 - z1;

//         double l = 0.0;
//         double r = 1.0;

//         double ans = 0;

//         while (r - l > 1e-9) {
//             double m1 = l + (r - l) / 3;
//             double m2 = r - (r - l) / 3;

//             double m1x = x1 + m1 * dx;
//             double m1y = y1 + m1 * dy;
//             double m1z = z1 + m1 * dz;

//             double m2x = x1 + m2 * dx;
//             double m2y = y1 + m2 * dy;
//             double m2z = z1 + m2 * dz;

//             double d1 = dist(m1x, m1y, m1z, x3, y3, z3);
//             double d2 = dist(m2x, m2y, m2z, x3, y3, z3);

//             if (d1 < d2) {
//                 r = m2;
//             } else {
//                 l = m1;
//             }
//         }
//         ans = (l + r) / 2;

//         double ansx = x1 + dx * ans;
//         double ansy = y1 + dy * ans;
//         double ansz = z1 + dz * ans;

//         System.out.printf("%.10f", dist(ansx, ansy, ansz, x3, y3, z3));

//     }
// }

import java.io.*;
import java.util.*;

class baek__11664 {
    static int dx;
    static int dy;
    static int dz;

    static int ax;
    static int ay;
    static int az;

    static int cx;
    static int cy;
    static int cz;

    static double calc(double m) {

        double x = ax + dx * m;
        double y = ay + dy * m;
        double z = az + dz * m;

        return Math.sqrt((x - cx) * (x - cx) + (y - cy) * (y - cy) + (z - cz) * (z - cz));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        ax = Integer.parseInt(temp[0]);
        ay = Integer.parseInt(temp[1]);
        az = Integer.parseInt(temp[2]);

        int bx = Integer.parseInt(temp[3]);
        int by = Integer.parseInt(temp[4]);
        int bz = Integer.parseInt(temp[5]);

        cx = Integer.parseInt(temp[6]);
        cy = Integer.parseInt(temp[7]);
        cz = Integer.parseInt(temp[8]);

        double l = 0;
        double r = 1;

        dx = bx - ax;
        dy = by - ay;
        dz = bz - az;

        while (r - l > 1e-9) {
            double m1 = l + (r - l) / 3;
            double m2 = r - (r - l) / 3;

            if (calc(m1) < calc(m2)) {
                r = m2;
            } else {
                l = m1;
            }
        }

        double ans = calc(l);

        System.out.printf("%.9f", ans);
    }
}