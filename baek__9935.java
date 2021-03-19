import java.io.*;
import java.util.*;

class baek__9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String ex = br.readLine();

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        boolean[] check = new boolean[s.length()];
        Arrays.fill(check, true);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ex.charAt(0)) {
                st1.add(0);
                st2.add(i);
                if (st1.peek() == ex.length() - 1) {
                    for (int j = 0; j < ex.length(); j++) {
                        st1.pop();
                        check[st2.pop()] = false;
                    }
                }
            } else {
                if (st1.isEmpty())
                    continue;
                if (s.charAt(i) == ex.charAt(st1.peek() + 1)) {
                    st1.add(st1.peek() + 1);
                    st2.add(i);
                    if (st1.peek() == ex.length() - 1) {
                        for (int j = 0; j < ex.length(); j++) {
                            st1.pop();
                            check[st2.pop()] = false;
                        }
                    }
                } else {
                    while (!st1.isEmpty()) {
                        st1.pop();
                        st2.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (check[i]) {
                sb.append(s.charAt(i));
            }
        }

        System.out.print(sb.toString().length() == 0 ? "FRULA" : sb);
    }
}
