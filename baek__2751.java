import java.io.*;
import java.util.*;

class baek__2751 {

    static void shuffle(int[] arr) {
        Random random = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    static void merge(int[] arr, int start, int end) {
        int mid = (start + end) / 2;

        int a = start;
        int b = mid + 1;
        int[] array = new int[end - start + 1];
        int idx = 0;

        while (a <= mid && b <= end) {
            if (arr[a] < arr[b]) {
                array[idx++] = arr[a++];
            } else {
                array[idx++] = arr[b++];
            }
        }

        while (a <= mid) {
            array[idx++] = arr[a++];
        }
        while (b <= mid) {
            array[idx++] = arr[b++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = array[i - start];
        }
    }

    static void sort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sort(arr, 0, arr.length - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + "\n");
        }

        System.out.print(sb);

    }
}