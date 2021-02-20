import java.io.*;
import java.util.*;

class baek__2002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), i);
        }

        String[] out = new String[n];
        int pass = 0;

        for (int i = 0; i < n; i++) {
            out[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map.get(out[i]) > map.get(out[j])) {
                    pass++;
                    break;
                }
            }
        }

        System.out.print(pass);
    }
}
