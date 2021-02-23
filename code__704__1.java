import java.io.*;
import java.util.*;

public class code__704__1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        String[] temp;

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            temp = br.readLine().split(" ");
            long p = Long.parseLong(temp[0]);
            long a = Long.parseLong(temp[1]);
            long b = Long.parseLong(temp[2]);
            long c = Long.parseLong(temp[3]);

            long t1 = p % a == 0 ? 0 : (p / a + 1) * a - p;
            long t2 = p % b == 0 ? 0 : (p / b + 1) * b - p;
            long t3 = p % c == 0 ? 0 : (p / c + 1) * c - p;

            long ans = Math.min(t1, t2);
            ans = Math.min(ans, t3);
            sb.append(ans + "\n");
        }
        System.out.print(sb);
    }
}
