import java.io.*;
import java.util.*;

class baek__14888 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        ArrayList<Integer> operator = new ArrayList<>();
        int m = 0;
        temp = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            int k = Integer.parseInt(temp[i]);

            while (k-- > 0) {
                operator.add(i);
            }
        }

        Collections.sort(operator);
        Integer[] ops = operator.toArray(new Integer[operator.size()]);

        ArrayList<Integer> answer = new ArrayList<>();
        do {
            answer.add(calc(ops, nums));
        } while (next_permutation(ops));

        Collections.sort(answer);

        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));
    }

    static Integer calc(Integer[] operators, int[] nums) {
        Integer sum = nums[0];

        for (int i = 0; i < operators.length; i++) {
            if (operators[i] == 0) {
                sum += nums[i + 1];
            } else if (operators[i] == 1) {
                sum -= nums[i + 1];
            } else if (operators[i] == 2) {
                sum *= nums[i + 1];
            } else {
                sum /= nums[i + 1];
            }
        }

        return sum;
    }

    static boolean next_permutation(Integer[] arr) {
        int start = -1;
        int k = arr.length;

        for (int i = k - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                start = i - 1;
                break;
            }
        }

        if (start == -1)
            return false;

        for (int i = k - 1; i > start; i--) {
            if (arr[start] < arr[i]) {
                swap(arr, start, i);
                break;
            }
        }

        start++;
        int end = k - 1;

        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }

        return true;
    }

    static void swap(Integer[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}