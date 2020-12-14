import java.io.*;

class prob__1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        if (n == 1) {
            System.out.print(1);
            return;
        }

        if (n == 2) {
            System.out.print(Math.min(4, (m + 1) / 2));
            return;
        }

        if (m < 7) {
            System.out.print(Math.min(4, m));
            return;
        }

        System.out.print(m - 2);
    }
}
