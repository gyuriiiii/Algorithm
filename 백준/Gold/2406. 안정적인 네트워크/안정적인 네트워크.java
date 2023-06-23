import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int totalCost;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        int[][] weight = new int[n + 1][n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        ArrayList<Node> connect = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                weight[i][j] = cost;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                pq.add(new Node(i, j, weight[i][j]));
            }
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (find(now.a) != find(now.b)) {
                union(now.a, now.b);
                totalCost += now.cost;
                connect.add(new Node(now.a, now.b, 0));
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(totalCost + " " + connect.size() + "\n");
        for (int i = 0; i < connect.size(); i++) {
            sb.append(connect.get(i).a + " " + connect.get(i).b + "\n");
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        parent[x] = y;
    }

    static private int find(int a) {
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