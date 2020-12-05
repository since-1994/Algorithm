import java.io.*;
import java.util.*;

class baek__6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] temp = br.readLine().split(" ");
            int[] nums = new int[temp.length];
            if (nums.length == 0)
                break;

            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(temp[i]);
            }
        }
    }

    static void go(int idx, int[] nums, int cnt) {

    }
}
