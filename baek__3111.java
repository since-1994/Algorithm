import java.io.*;
import java.util.*;

class baek__3111 {
    static String a;
    static String t;

    static boolean check(Stack<Integer> stack, boolean reverse) {
        Stack<Integer> temp = new Stack<>();

        if (reverse) {
            int idx = 0;
            while (!stack.empty() && idx < a.length()) {
                int now = stack.pop();
                temp.add(now);
                if (t.charAt(now) != a.charAt(idx++)) {
                    while (!temp.empty()) {
                        stack.add(temp.pop());
                    }
                    return false;
                }
            }
            if (idx < a.length()) {
                while (!temp.empty()) {
                    stack.add(temp.pop());
                }
                return false;
            }

        } else {
            int idx = a.length() - 1;
            while (!stack.empty() && idx >= 0) {
                int now = stack.pop();
                temp.add(now);
                if (t.charAt(now) != a.charAt(idx--)) {
                    while (!temp.empty()) {
                        stack.add(temp.pop());
                    }
                    return false;
                }
            }
            if (idx >= 0) {
                while (!temp.empty()) {
                    stack.add(temp.pop());
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        t = br.readLine();

        Stack<Integer> stackL = new Stack<>();
        Stack<Integer> stackR = new Stack<>();

        int l = 0;
        int r = t.length() - 1;

        int turn = 0;
        while (l <= r) {
            if (turn == 0) {
                while (l <= r && l < t.length()) {
                    stackL.add(l++);
                    if (t.charAt(stackL.peek()) == a.charAt(a.length() - 1)) {
                        if (check(stackL, false))
                            break;
                    }
                }
                turn = 1;
            } else {
                while (l <= r && r >= 0) {
                    stackR.add(r--);
                    if (t.charAt(stackR.peek()) == a.charAt(0)) {
                        if (check(stackR, true)) {
                            break;
                        }
                    }
                }
                turn = 0;
            }
        }
        StringBuilder sb = new StringBuilder();

        while (!stackL.empty()) {
            stackR.add(stackL.pop());
            if (t.charAt(stackR.peek()) == a.charAt(0)) {
                check(stackR, true);
            }
        }
        while (!stackR.empty()) {
            sb.append(t.charAt(stackR.pop()));
        }

        System.out.print(sb);
    }
}