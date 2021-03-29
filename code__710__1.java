import java.io.*;
import java.util.*;

public class code__710__1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            String[] temp = br.readLine().split(" ");

            long n = Long.parseLong(temp[0]);
            long m = Long.parseLong(temp[1]);
            long target = Long.parseLong(temp[2]);
            target -= 1;

            long c = target / n;
            long r = target % n;

            sb.append((r * m + c + 1) + "\n");
        }

        System.out.print(sb);
    }
}
