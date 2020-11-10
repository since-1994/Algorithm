import java.io.*;
import java.util.*;

class Edge{
    int from;
    int to;

    Edge(int from, int to){
        this.from = from;
        this.to = to;
    }
}

class prob__13023 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        ArrayList<Edge> edges = new ArrayList<>();

        for(int i = 0 ; i<m; i++){
            temp = br.readLine().split(" ");

            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);

            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
        }

        boolean isAnswerExist = false;

        for(int i  =0; i<2*m; i++){
            for(int j = 0; j<2*m; j++){
                int A = edges.get(i).from;
                int B = edges.get(i).to;
                int C = edges.get(j).from;
                int D = edges.get(j).to;

                if(A==C || B==C || A==D || B==D){
                    continue;
                }

                for(int k = 0; k<2*m ; k++){
                    if(edges.get(k).from == D){
                        int E = edges.get(k).to;

                        if(E == A || E == B || E == C){
                            continue;
                        }

                        isAnswerExist = true;
                    }
                }
            }
        }

        System.out.print(isAnswerExist ?  1 : 0);
    }
}
