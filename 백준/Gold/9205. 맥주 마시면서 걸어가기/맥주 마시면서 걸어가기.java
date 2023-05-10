import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static ArrayList<Node> list;
    static Node start, end;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();

            list = new ArrayList<>(); 
            visited = new boolean[n + 2];

            start = new Node(sc.nextInt(), sc.nextInt());
            for (int j = 0; j < n; j++) {
                list.add(new Node(sc.nextInt(), sc.nextInt()));
            }
            end = new Node(sc.nextInt(), sc.nextInt());

            if (bfs(start)) {
                System.out.println("happy");
            }
            else {
                System.out.println("sad");
            }
        }
    }

    private static boolean bfs(Node node) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(node);

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (getDistance(now, end) <= 1000) {
                return true;
            }

            for (int i = 0; i < list.size(); i++) {
                if (!visited[i]) {
                    if (getDistance(now, list.get(i)) <= 1000) {
                        visited[i] = true;
                        dq.add(list.get(i));
                    }
                }
            }
        }
        return false;
    }

    private static int getDistance(Node n1, Node n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }

    static public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}