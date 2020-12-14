import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n  = Integer.parseInt(br.readLine());

        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> plus = new ArrayList<>();

        boolean isZeroExist = false;
        int numberOfOne = 0;

        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 1){
                numberOfOne += 1;
            }
            else if(num == 0){
                isZeroExist = true;
            }
            else if(num > 0){
                plus.add(num);
            }
            else if(num < 0){
                minus.add(num);
            }
        }
        int answer = 0;

        if(plus.size()%2 != 0) plus.add(1);
        Collections.sort(plus);

        if(minus.size()%2 != 0) {
            if(isZeroExist) minus.add(0);
            else minus.add(1);
        }
        Collections.sort(minus);

        for(int i  =0; i<plus.size(); i += 2){
            answer += (plus.get(i) * plus.get(i+1));
        }

        for(int i =0 ; i < minus.size(); i+=2){
            answer += (minus.get(i) * minus.get(i+1));
        }

        System.out.print(answer+numberOfOne);
    }
}