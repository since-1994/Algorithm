import java.io.*;
import java.util.*;

class baek__15658 {

    static ArrayList<Integer> answer = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        temp = br.readLine().split(" ");
        int[] ops = new int[4];

        for (int i = 0; i < 4; i++) {// +=*/
            ops[i] = Integer.parseInt(temp[i]);
        }

        go(nums, 1, nums[0], ops[0], ops[1], ops[2], ops[3]);

        Collections.sort(answer);

        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));

    }

    static void go(int[] nums, int idx, int sum, int plus, int minus, int mult, int div) {
        if (idx == nums.length) {
            answer.add(sum);
            return;
        }

        if (plus > 0) {
            go(nums, idx + 1, sum + nums[idx], plus - 1, minus, mult, div);
        }

        if (minus > 0) {
            go(nums, idx + 1, sum - nums[idx], plus, minus - 1, mult, div);
        }
        if (mult > 0) {
            go(nums, idx + 1, sum * nums[idx], plus, minus, mult - 1, div);
        }
        if (div > 0) {
            go(nums, idx + 1, sum / nums[idx], plus, minus, mult, div - 1);
        }

    }

}