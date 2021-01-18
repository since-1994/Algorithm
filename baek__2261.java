import java.io.*;
import java.util.*;

class ComparatorX implements Comparator<Point> {
    public int compare(Point u, Point v) {
        if (u.x < v.x)
            return -1;
        else if (u.x == v.x)
            return 0;
        return 1;
    }
}

class ComparatorY implements Comparator<Point> {
    public int compare(Point u, Point v) {
        if (u.y < v.y)
            return -1;
        else if (u.y == v.y)
            return 0;
        return 1;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class baek__2261 {
    static Point[] points;

    static int dist(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    static int getMinimum(int start, int end) {
        int ans = -1;

        for (int i = start; i <= end - 1; i++) {
            for (int j = i + 1; j <= end; j++) {
                int d = dist(points[i], points[j]);
                ans = ans == -1 ? d : Math.min(ans, d);
            }
        }

        return ans;
    }

    static int go(int start, int end, ArrayList<Point> list) {
        if (end - start + 1 <= 3) {
            return getMinimum(start, end);
        }

        int mid = (start + end) / 2;
        ArrayList<Point> listL = new ArrayList<>();
        ArrayList<Point> listR = new ArrayList<>();
        for (Point point : list) {
            if (point.x <= points[mid].x)
                listL.add(point);
            else
                listR.add(point);
        }

        int d1 = go(start, mid, listL);
        int d2 = go(mid + 1, end, listR);

        int ans = Math.min(d1, d2);

        ArrayList<Point> listMid = new ArrayList<>();
        for (Point point : list) {
            if ((point.x - points[mid].x) * (point.x - points[mid].x) < ans)
                listMid.add(point);
        }

        for (int i = 0; i < listMid.size() - 1; i++) {
            for (int j = i + 1; j < listMid.size(); j++) {
                int d = listMid.get(i).y - listMid.get(j).y;
                if (d * d < ans) {
                    if (dist(listMid.get(i), listMid.get(j)) < ans)
                        ans = dist(listMid.get(i), listMid.get(j));
                } else {
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        points = new Point[n];
        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            points[i] = new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        ArrayList<Point> list = new ArrayList<>();
        list = new ArrayList<>(Arrays.asList(points));

        Arrays.sort(points, new ComparatorX());
        Collections.sort(list, new ComparatorY());

        System.out.print(go(0, n - 1, list));
    }
}