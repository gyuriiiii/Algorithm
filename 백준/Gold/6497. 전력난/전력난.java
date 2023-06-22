import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int originCost = 0; // 기존 금액
            int totalCost = 0;

            int m = sc.nextInt();
            int n = sc.nextInt();

            if (m == 0 && n == 0) {
                break;
            }

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            ArrayList<Node> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();

                originCost += z;
                list.add(new Node(x, y, z));
            }

            list.sort(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

            for (Node node : list) {
                if (find(node.a) != find(node.b)) {
                    union(node.a, node.b);
                    totalCost += node.cost;
                }
            }
            System.out.println(originCost - totalCost);
        }
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