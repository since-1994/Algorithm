import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Meeting that) {
        if (this.end < that.end) {
            return -1;
        } else if (this.end == that.end) {
            if (this.start < that.start)
                return -1;
            else
                return 1;
        }
        return 1;
    }

}

class baek__1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        Arrays.sort(meetings);
        int now = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (meetings[i].start >= now) {
                answer++;
                now = meetings[i].end;
            }
        }

        System.out.print(answer);
    }
}
