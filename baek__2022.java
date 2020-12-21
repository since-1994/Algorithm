import java.io.*;
import java.util.*;

class baek__2022 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        double x = Double.parseDouble(temp[0]);
        double y = Double.parseDouble(temp[1]);
        double c = Double.parseDouble(temp[2]);

        double l = 0;
        double r = Math.max(x, y);
        double d = 0;

        while (Math.abs(r - l) > 1e-3) {
            double mid = (r + l) / 2;
            double h1 = Math.sqrt(x * x - mid * mid);
            double h2 = Math.sqrt(y * y - mid * mid);
            double h = (h1 * h2) / (h1 + h2);

            if (h > c) {
                l = mid;
            } else {
                d = mid;
                r = mid;
            }
        }

        System.out.printf("%.3f", d);
    }
}