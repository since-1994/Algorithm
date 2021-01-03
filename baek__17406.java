import java.io.*;
import java.util.*;

class Method {
    int x;
    int y;
    int size;

    Method(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
}

class baek__17406 {

    static boolean next_permutation(int[] arr) {
        int n = arr.length;
        int start = -1;

        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                start = i - 1;
                break;
            }
        }

        if (start == -1)
            return false;

        for (int i = n - 1; i > start; i--) {
            if (arr[i] > arr[start]) {
                int temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
                break;
            }
        }

        start += 1;
        int end = n - 1;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return true;
    }

    static void circ(Method method, int[][] map) {
        int x = method.x - 1;
        int y = method.y - 1;
        int size = method.size;

        Queue<Integer> q = new LinkedList<>();

        for (int k = 1; k <= size; k++) {
            for (int i = x - k, j = y - k; j < y + k; j++) {
                q.add(map[i][j]);
            }
            for (int i = x - k, j = y + k; i < x + k; i++) {
                q.add(map[i][j]);
            }
            for (int i = x + k, j = y + k; j > y - k; j--) {
                q.add(map[i][j]);
            }
            for (int i = x + k, j = y - k; i > x - k; i--) {
                q.add(map[i][j]);
            }
            for (int i = x - k, j = y - k + 1; j <= y + k; j++) {
                map[i][j] = q.poll();
            }
            for (int i = x - k + 1, j = y + k; i <= x + k; i++) {
                map[i][j] = q.poll();
            }
            for (int i = x + k, j = y + k - 1; j >= y - k; j--) {
                map[i][j] = q.poll();
            }
            for (int i = x + k - 1, j = y - k; i >= x - k; i--) {
                map[i][j] = q.poll();
            }
        }

    }

    static int go(Method[] methods, int[] dirs, int[][] map, int n, int m) {
        for (int dir : dirs) {
            Method method = methods[dir];
            circ(method, map);
        }

        int returnValue = 100 * 50;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += map[i][j];
            }
            returnValue = Math.min(sum, returnValue);
        }

        return returnValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int k = Integer.parseInt(temp[2]);

        int[][] numbers = new int[n][m];

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                numbers[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Method[] methods = new Method[k];
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = i;
            temp = br.readLine().split(" ");
            methods[i] = new Method(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
        }

        int ans = 100 * 50;

        do {
            int[][] copy = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copy[i][j] = numbers[i][j];
                }
            }
            ans = Math.min(ans, go(methods, arr, copy, n, m));
        } while (next_permutation(arr));

        System.out.print(ans);

    }
}