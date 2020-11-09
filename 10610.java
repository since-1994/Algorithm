import java.io.*;
import java.util.*;

class prob__10610{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] temp = br.readLine().toCharArray();
        int n = temp.length;
        Integer[] number = new Integer[n];

        for(int i = 0; i<n; i++){
            number[i] = temp[i]-'0';
        }

        Arrays.sort(number, Collections.reverseOrder());


        long sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            sb.append(number[i]);
            sum += number[i];
        }

        if(sum%3 != 0 || number[n-1] != 0){
            System.out.print(-1);
            return;
        }

        System.out.print(sb.toString());
    }
}