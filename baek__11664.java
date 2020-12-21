import java.io.*;
import java.util.*;

class baek__11664 {

    static double dist(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        double x1 = Double.parseDouble(temp[0]);
        double y1 = Double.parseDouble(temp[1]);
        double z1 = Double.parseDouble(temp[2]);

        double x2 = Double.parseDouble(temp[3]);
        double y2 = Double.parseDouble(temp[4]);
        double z2 = Double.parseDouble(temp[5]);

        double x3 = Double.parseDouble(temp[6]);
        double y3 = Double.parseDouble(temp[7]);
        double z3 = Double.parseDouble(temp[8]);

        double dx = x2 - x1;
        double dy = y2 - y1;
        double dz = z2 - z1;

        double l = 0.0;
        double r = 1.0;

        double ans = 0;

        while (true) {
            if (Math.abs(r - l) < 1e-9) {
                ans = (l + r) / 2;
                break;
            }
            double m1 = l + (r - l) / 3;
            double m2 = r - (r - l) / 3;

            double m1x = x1 + m1 * dx;
            double m1y = y1 + m1 * dy;
            double m1z = z1 + m1 * dz;

            double m2x = x1 + m2 * dx;
            double m2y = y1 + m2 * dy;
            double m2z = z1 + m2 * dz;

            double d1 = dist(m1x, m1y, m1z, x3, y3, z3);
            double d2 = dist(m2x, m2y, m2z, x3, y3, z3);

            if (d1 > d2) {
                l = m1;
            } else {
                r = m2;
            }
        }

        double ansx = x1 + dx * ans;
        double ansy = y1 + dy * ans;
        double ansz = z1 + dz * ans;

        System.out.printf("%.10f", dist(ansx, ansy, ansz, x3, y3, z3));

    }
}