import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int INF = 987654321;
    static int[] dis;
    static ArrayList<Node>[] adjList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt();

        dis = new int[V + 1];
        Arrays.fill(dis, INF);

        adjList = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adjList[u].add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dis.length; i++) {
            if (dis[i] == INF) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(dis[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        pq.add(new Node(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : adjList[now.end]) {
                if (dis[next.end] > now.cost + next.cost) {
                    dis[next.end] = now.cost + next.cost;
                    pq.add(new Node(next.end, dis[next.end]));
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