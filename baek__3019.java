import java.io.*;
import java.util.*;

class baek__3019 {

    static String[] block1 = { "0", "0000" };
    static String[] block2 = { "00" };
    static String[] block3 = { "001", "10" };
    static String[] block4 = { "100", "01" };
    static String[] block5 = { "000", "01", "101", "10" };
    static String[] block6 = { "000", "00", "011", "20" };
    static String[] block7 = { "000", "02", "110", "00" };

    // static String[] block2 = {""}

    static int go(String block, int[] line, int start) {
        if (start + block.length() > line.length) {
            return 0;
        }
        int base = (block.charAt(0) - '0') - line[start];
        for (int i = 1; i < block.length(); i++) {
            if ((block.charAt(i) - '0') - line[start + i] != base)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int c = Integer.parseInt(temp[0]);
        int type = Integer.parseInt(temp[1]);

        int[] line = new int[c];
        temp = br.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            line[i] = Integer.parseInt(temp[i]);
        }

        int ans = 0;

        if (type == 1) {
            for (String block : block1) {
                for (int i = 0; i < c; i++) {
                    ans += go(block, line, i);
                }
            }
        }
        if (type == 2) {
            for (String block : block2) {
                for (int i = 0; i < c; i++) {
                    ans += go(block, line, i);
                }
            }
        }
        if (type == 3) {
            for (String block : block3) {
                for (int i = 0; i < c; i++) {
                    ans += go(block, line, i);
                }
            }
        }
        if (type == 4) {
            for (String block : block4) {
                for (int i = 0; i < c; i++) {
                    ans += go(block, line, i);
                }
            }
        }
        if (type == 5) {
            for (String block : block5) {
                for (int i = 0; i < c; i++) {
                    ans += go(block, line, i);
                }
            }
        }
        if (type == 6) {
            for (String block : block6) {
                for (int i = 0; i < c; i++) {
                    ans += go(block, line, i);
                }
            }
        }
        if (type == 7) {
            for (String block : block7) {
                for (int i = 0; i < c; i++) {
                    ans += go(block, line, i);
                }
            }
        }

        System.out.print(ans);

    }
}