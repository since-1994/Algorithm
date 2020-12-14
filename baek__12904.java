import java.io.*;
import java.util.*;

class baek__12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        while (t.length() > s.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t = t.substring(0, t.length() - 1);
            } else {
                t = t.substring(0, t.length() - 1);
                t = new StringBuilder(t).reverse().toString();
            }
        }

        if (s.equals(t))
            System.out.print(1);
        else
            System.out.print(0);
    }
}