import java.io.*;
import java.util.*;

class baek__16198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> nums = new ArrayList<>();
        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(temp[i]));
        }
        System.out.print(go(nums, 0));
    }

    static int go(ArrayList<Integer> a, int energy) {
        if (a.size() == 2)
            return energy;

        int returnValue = 0;

        for (int i = 1; i < a.size() - 1; i++) {
            ArrayList<Integer> b = new ArrayList<>(a);
            b.remove(i);
            returnValue = Math.max(returnValue, go(b, energy + (a.get(i - 1) * a.get(i + 1))));
        }

        return returnValue;
    }
}