import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if (this.x == p.x) {
                return Integer.compare(this.y, p.y);
            } 
            else {
                return Integer.compare(this.x, p.x);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(points[i].x).append(" ").append(points[i].y).append("\n");
        }
        System.out.println(sb);
    }
}