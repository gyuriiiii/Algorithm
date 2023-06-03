import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int INF = 987654321;
    static boolean[] visited;
    static int[] dis;
    static ArrayList<Node>[] adjList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt();

        visited = new boolean[V + 1];
        dis = new int[V + 1];
        adjList = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
            dis[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adjList[u].add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=V; i++) {
            if (dis[i] == INF) {
                sb.append("INF\n");
            }
            else {
                sb.append(dis[i] + "\n");
            }
        }
        System.out.println(sb);
    }

    private static void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

        dis[k] = 0;
        pq.add(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;

            for (Node next : adjList[now.end]) {
                if (dis[next.end] > dis[now.end] + next.cost) {
                    dis[next.end] = dis[now.end] + next.cost; // 최단 거리 갱신
                    pq.add(new Node(next.end, dis[next.end])); // 우선순위 큐에 추가
                }
            }
        }
    }

    static public class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}