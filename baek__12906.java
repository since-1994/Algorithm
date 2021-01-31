import java.io.*;
import java.util.*;

class baek__12906 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] start = new String[3];
        Arrays.fill(start, "");
        String[] temp = br.readLine().split(" ");
        if (!temp[0].equals("0"))
            start[0] = temp[1];
        temp = br.readLine().split(" ");
        if (!temp[0].equals("0"))
            start[1] = temp[1];
        temp = br.readLine().split(" ");
        if (!temp[0].equals("0"))
            start[2] = temp[1];

        char[] arr = (start[0] + start[1] + start[2]).toCharArray();
        String[] target = new String[3];
        Arrays.fill(target, "");

        for (int idx = 0; idx < 3; idx++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'A' + idx) {
                    target[idx] += arr[i];
                }
            }
        }

        // for (int i = 0; i < 3; i++) {
        // System.out.print(target[i] + " ");
        // }

        HashMap<List<String>, Integer> map = new HashMap<>();
        Queue<List<String>> q = new LinkedList<>();
        q.add(Arrays.asList(start));
        map.put(Arrays.asList(start), 0);

        while (!q.isEmpty()) {
            String[] cur = q.poll().toArray(new String[3]);
            int d = map.get(Arrays.asList(cur));

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j)
                        continue;
                    if (cur[i].equals(""))
                        continue;
                    String[] now = cur.clone();
                    char moved = now[i].charAt(now[i].length() - 1);
                    now[i] = now[i].substring(0, now[i].length() - 1);
                    now[j] = now[j] + moved;

                    if (map.containsKey(Arrays.asList(now)))
                        continue;
                    map.put(Arrays.asList(now), d + 1);
                    q.add(Arrays.asList(now));
                }
            }
        }

        System.out.print(map.get(Arrays.asList(target)));

    }
}