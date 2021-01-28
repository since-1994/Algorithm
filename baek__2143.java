import java.io.*;
import java.util.*;

class baek__2143 {

    static ArrayList<Integer> getSum(int n, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                list.add(sum);
            }
        }

        return list;
    }

    static int upperBound(int t, ArrayList<Integer> list) {
        int l = 0;
        int r = list.size() - 1;

        int idx = list.size();

        while (l <= r) {
            int mid = (l + r) / 2;

            if (list.get(mid) == t) {
                l = mid + 1;
            } else if (list.get(mid) > t) {
                r = mid - 1;
                idx = mid;
            } else if (list.get(mid) < t) {
                l = mid + 1;
            }
        }

        return idx;
    }

    static int lowerBound(int t, ArrayList<Integer> list) {
        int l = 0;
        int r = list.size() - 1;

        int idx = list.size();

        while (l <= r) {
            int mid = (l + r) / 2;

            if (list.get(mid) == t) {
                r = mid - 1;
                idx = mid;
            } else if (list.get(mid) > t) {
                r = mid - 1;
                idx = mid;
            } else if (list.get(mid) < t) {
                l = mid + 1;
            }
        }

        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(temp[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        temp = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(temp[i]);
        }

        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();

        // 부배열 의 합 구하기
        listA = getSum(n, a);
        listB = getSum(m, b);

        // 정렬 사실 B만 해도 된다..ㅋㅋ
        Collections.sort(listA);
        Collections.sort(listB);

        long ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int number : listB) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }

        for (int i : listA) {
            int target = t - i;
            if (map.containsKey(target))
                ans += map.get(target);
        }

        System.out.print(ans);
    }
}