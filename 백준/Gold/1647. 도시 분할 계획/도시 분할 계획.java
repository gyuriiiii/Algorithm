import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            list.add(new Node(A, B, C));
        }

        list.sort(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

        for (Node node : list) {
            if (find(node.a) != find(node.b)) {
                union(node.a, node.b);
                pq.add(node.cost);
            }
        }

        pq.poll();

        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        parent[x] = y;
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