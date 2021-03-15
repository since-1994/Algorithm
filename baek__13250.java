import java.io.*;
import java.util.*;

class baek__13250 {
    static int MAX = 1000000;
    static double[] d = new double[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j < 0)
                    d[i] += 1 / 6.0;
                else
                    d[i] += (d[i - j] + 1) / 6.0;
            }
        }

        System.out.print(d[n]);
    }
}
