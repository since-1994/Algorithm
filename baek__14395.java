import java.io.*;
import java.util.*;

class baek__14395 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        long s = Long.parseLong(temp[0]);
        long t = Long.parseLong(temp[1]);

        if (s == t) {
            System.out.print(0);
            return;
        }

        HashSet<Long> check = new HashSet<>();

        Queue<String> methodq = new LinkedList<>();
        Queue<Long> q = new LinkedList<>();

        q.add(s);
        methodq.add("");
        check.add(s);

        while (!q.isEmpty()) {
            String method = methodq.poll();
            long cur = q.poll();

            if (cur == t) {
                System.out.print(method);
                return;
            }

            long nex = cur * cur;
            if (!check.contains(nex) && nex >= 0 && nex <= 1000000000) {
                check.add(nex);
                methodq.add(method + "*");
                q.add(nex);
            }
            nex = cur + cur;
            if (!check.contains(nex) && nex >= 0 && nex <= 1000000000) {
                check.add(nex);
                methodq.add(method + "+");
                q.add(nex);
            }

            nex = cur - cur;
            if (!check.contains(nex) && nex >= 0 && nex <= 1000000000) {
                check.add(nex);
                methodq.add(method + "-");
                q.add(nex);
            }

            if (cur == 0)
                continue;
            nex = cur / cur;
            if (!check.contains(nex) && nex >= 0 && nex <= 1000000000) {
                check.add(nex);
                methodq.add(method + "/");
                q.add(nex);
            }

        }

        System.out.print(-1);

    }
}