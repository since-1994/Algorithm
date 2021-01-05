import java.io.*;
import java.util.*;

class baek__16638 {
    static int n;
    static int[] priority = new int[256];

    static void bracket(int k, int[] numbers, char[] ops) {
        for (int i = 0; i < n / 2; i++) {
            if ((k & (1 << i)) > 0) {
                if (ops[i] == '+') {
                    int temp = numbers[i] + numbers[i + 1];
                    numbers[i] = temp;
                    numbers[i + 1] = 0;
                    ops[i] = '/';
                } else if (ops[i] == '-') {
                    int temp = numbers[i] - numbers[i + 1];
                    numbers[i] = temp;
                    numbers[i + 1] = 0;
                    ops[i] = '/';
                } else if (ops[i] == '*') {
                    int temp = numbers[i] * numbers[i + 1];
                    numbers[i] = temp;
                    numbers[i + 1] = 0;
                    ops[i] = '/';
                }
            }
        }
    }

    static String[] combine(int[] numbers, char[] ops) {
        String[] arr = new String[n];

        for (int i = 0; i < n / 2; i++) {
            arr[i * 2] = Integer.toString(numbers[i]);
            arr[i * 2 + 1] = Character.toString(ops[i]);
        }
        arr[n - 1] = Integer.toString(numbers[n / 2]);

        return arr;
    }

    static long go(int k, int[] numbers, char[] ops) {
        bracket(k, numbers, ops);
        String[] arr = combine(numbers, ops);

        // for (int i = 0; i < n; i++) {
        // System.out.print(arr[i] + " ");
        // }

        ArrayList<String> list = new ArrayList<>();
        Stack<String> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") || arr[i].equals("/")) {
                if (st.isEmpty()) {
                    st.add(arr[i]);
                } else {
                    if (priority[st.peek().charAt(0)] <= priority[arr[i].charAt(0)]) {
                        while (!st.isEmpty() && priority[st.peek().charAt(0)] <= priority[arr[i].charAt(0)]) {
                            list.add(st.pop());
                        }
                        st.add(arr[i]);
                    } else {
                        st.add(arr[i]);
                    }
                }
            } else {
                list.add(arr[i]);
            }
        }

        while (!st.isEmpty()) {
            list.add(st.pop());
        }

        Stack<Long> ans = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (list.get(i).equals("+")) {
                long b = ans.pop();
                long a = ans.pop();
                ans.add(a + b);
            } else if (list.get(i).equals("-")) {
                long b = ans.pop();
                long a = ans.pop();
                ans.add(a - b);
            } else if (list.get(i).equals("*")) {
                long b = ans.pop();
                long a = ans.pop();
                ans.add(a * b);
            } else if (list.get(i).equals("/")) {
                long b = ans.pop();
                long a = ans.pop();
                ans.add(a + b);
            } else {
                ans.add(Long.parseLong(list.get(i)));
            }
        }
        long returnValue = ans.pop();
        return returnValue;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        priority['/'] = -1;
        priority['*'] = 0;
        priority['+'] = 1;
        priority['-'] = 1;

        char[] temp = br.readLine().toCharArray();

        int[] numbers = new int[n / 2 + 1];
        int idx1 = 0;

        char[] ops = new char[n / 2];
        int idx2 = 0;

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '+' || temp[i] == '-' || temp[i] == '*') {
                ops[idx2++] = temp[i];
            } else {
                numbers[idx1++] = temp[i] - '0';
            }
        }

        long ans = -(1 << 31);

        for (int k = 0; k < (1 << (n / 2)); k++) {
            boolean ok = false;
            for (int i = 0; i < (n / 2 - 1); i++) {
                if ((k & (1 << i)) > 0 && (k & (1 << (i + 1))) > 0)
                    ok = true;

            }
            if (ok)
                continue;
            char[] ops_copy = ops.clone();
            int[] numbers_copy = numbers.clone();
            ans = Math.max(ans, go(k, numbers_copy, ops_copy));
        }

        System.out.print(ans);
    }
}