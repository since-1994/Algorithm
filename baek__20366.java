import java.io.*;
import java.util.*;

class baek__20366 {
    static int MAX = 2000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] temp = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(arr);

        int answer = MAX;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int h = arr[i] + arr[j];

                ArrayList<Integer> list = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        list.add(arr[k]);
                    }
                }
                int p1 = 0;
                int p2 = list.size() - 1;
                int sum = list.get(p1) + list.get(p2);
                int ans = MAX;
                while (p1 < p2) {
                    ans = Math.min(ans, Math.abs(sum - h));
                    if (sum <= h) {
                        sum -= list.get(p1);
                        p1++;
                        sum += list.get(p1);
                    } else {
                        sum -= list.get(p2);
                        p2--;
                        sum += list.get(p2);
                    }
                }

                answer = Math.min(answer, ans);
            }
        }

        System.out.print(answer);
    }
}
