import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int INF = 987654321;
    static int N;
    static ArrayList<Node>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int E = sc.nextInt();

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int sToV1 = dijkstra(1, v1); // 1 -> v1
        int sToV2 = dijkstra(1, v2); // 1 -> v2

        int v1Tov2 = dijkstra(v1, v2); // v1 -> v2
        if (v1Tov2 == INF) {
            System.out.println(-1);
            return;
        }

        int v2ToN = dijkstra(v2, N); // v2 -> N
        int v1ToN = dijkstra(v1, N); // v1 -> N

        int route1 = sToV1 + v1Tov2 + v2ToN;
        int route2 = sToV2 + v1Tov2 + v1ToN;

        int answer = Math.min(route1, route2);
        if (answer >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

        int[] dis = new int[N + 1];
        Arrays.fill(dis, INF);

        dis[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : list[now.end]) {
                if (dis[next.end] > dis[now.end] + next.cost) {
                    dis[next.end] = dis[now.end] + next.cost;
                    pq.add(new Node(next.end, dis[next.end]));
                }
            }
        }
        return dis[end];
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