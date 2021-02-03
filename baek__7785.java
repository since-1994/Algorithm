import java.io.*;
import java.util.*;

class baek__7785 {

    static class Custom implements Comparator<String> {
        public int compare(String u, String v) {
            return -u.compareTo(v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();

        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            String name = temp[0];
            String result = temp[1];

            if (map.containsKey(name)) {
                map.remove(name);
                map.put(name, result);
            } else {
                map.put(name, result);
            }
        }
        PriorityQueue<String> q = new PriorityQueue<>(1, new Custom());

        Set<String> set = map.keySet();
        for (String key : set) {
            if (map.get(key).equals("enter")) {
                q.add(key);
            }
        }

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}