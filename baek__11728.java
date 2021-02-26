import java.io.*;
import java.util.*;

class baek__11728 {
    static int[] shuffle(int[] arr) {
        for (int x = 0; x < arr.length; x++) {
            int i = (int) (Math.random() * arr.length);
            int j = (int) (Math.random() * arr.length);

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[] arr = new int[n];
        temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(arr);

        int[] brr = new int[m];
        temp = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            brr[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(brr);

        int pa = 0;
        int pb = 0;

        ArrayList<Integer> merged = new ArrayList<Integer>();

        while (pa < n && pb < m) {
            if (arr[pa] < brr[pb]) {
                merged.add(arr[pa]);
                pa++;
            } else {
                merged.add(brr[pb]);
                pb++;
            }
        }

        while (pa < n) {
            merged.add(arr[pa]);
            pa++;
        }
        while (pb < m) {
            merged.add(brr[pb]);
            pb++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < merged.size(); i++) {
            sb.append(merged.get(i) + " ");
        }
        System.out.print(sb);

    }
}
