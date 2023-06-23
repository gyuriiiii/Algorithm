import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Star[] starPos;
    static ArrayList<Node> adjList = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) {
        double answer = 0;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        starPos = new Star[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            starPos[i] = new Star(x, y);
        }

        for (int i = 0; i < starPos.length - 1; i++) {
            for (int j = i + 1; j < starPos.length; j++) {
                adjList.add(new Node(i, j, distance(starPos[i], starPos[j])));
            }
        }

        adjList.sort(((o1, o2) -> Double.compare(o1.cost, o2.cost)));

        for (Node node : adjList) {
            if (find(node.star1) != find(node.star2)) {
                union(node.star1, node.star2);
                answer += node.cost;
            }
        }

        System.out.printf("%.2f", answer);
    }

    private static double distance(Star star1, Star star2) {
        return Math.sqrt(Math.pow(Math.abs(star1.a - star2.a), 2.0) + Math.pow(Math.abs(star1.b - star2.b), 2.0));
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        parent[x] = y;
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static public class Star {
        double a;
        double b;

        public Star(double a, double b) {
            this.a = a;
            this.b = b;
        }
    }

    static public class Node {
        int star1;
        int star2;
        double cost;

        public Node(int star1, int star2, double cost) {
            this.star1 = star1;
            this.star2 = star2;
            this.cost = cost;
        }
    }
}