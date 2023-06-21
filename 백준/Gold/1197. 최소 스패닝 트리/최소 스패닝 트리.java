import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            list.add(new Node(A, B, C));
        }

        list.sort(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

        int answer = 0;
        for (Node node : list) {
            if (find(node.a) != find(node.b)) {
                union(node.a, node.b);
                answer += node.cost;
            }
        }

        System.out.println(answer);
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

    static public class Node {
        int a;
        int b;
        int cost;

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}