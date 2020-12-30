import java.io.*;
import java.util.*;

class baek__16637 {
    static int n;

    static void separate(int[] nums, char[] ops, char[] expression) {
        int numIdx = 0;
        int opIdx = 0;
        int num = 0;

        for (int i = 0; i < expression.length; i++) {
            if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*') {
                ops[opIdx++] = expression[i];
                nums[numIdx++] = num;
                num = 0;
            } else {
                num *= 10;
                num += expression[i] - '0';
            }
        }
        nums[numIdx] = num;
    }

    static boolean isVariable(int select) {
        for (int k = 1; k < n / 2; k++) {
            if (((1 << k) & select) > 0 && ((1 << (k - 1)) & select) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        char[] expression = br.readLine().toCharArray();

        int[] nums_og = new int[n / 2 + 1];
        char[] ops_og = new char[n / 2];

        separate(nums_og, ops_og, expression);

        int ans = -(1 << 31);

        for (int k = 0; k < (1 << ops_og.length); k++) {
            if (!isVariable(k))
                continue;
            int[] nums = nums_og.clone();
            char[] ops = ops_og.clone();

            for (int i = 0; i < ops.length; i++) {
                if (((1 << i) & k) > 0) {
                    if (ops[i] == '+') {
                        nums[i] = nums[i] + nums[i + 1];
                        nums[i + 1] = 0;
                        ops[i] = '+';
                    } else if (ops[i] == '-') {
                        nums[i] = nums[i] - nums[i + 1];
                        nums[i + 1] = 0;
                        ops[i] = '+';
                    } else {
                        nums[i] = nums[i] * nums[i + 1];
                        nums[i + 1] = 0;
                        ops[i] = '+';
                    }
                }
            }
            int result = nums[0];

            for (int i = 0; i < ops.length; i++) {
                if (ops[i] == '+') {
                    result += nums[i + 1];
                } else if (ops[i] == '-') {
                    result -= nums[i + 1];
                } else {
                    result *= nums[i + 1];
                }
            }

            ans = Math.max(result, ans);
        }

        System.out.print(ans);

    }
}