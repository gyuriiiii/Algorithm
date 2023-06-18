import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int INF = 987654321;
    static int[] dis;
    static ArrayList<Node>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        dis = new int[N + 1];
        Arrays.fill(dis, INF);

        adjList = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();
            adjList[s].add(new Node(e, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijkstra(start);
        System.out.println(dis[end]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        pq.add(new Node(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;

                for (Node next : adjList[now.end]) {
                    if (!visited[next.end] && dis[next.end] > now.cost + next.cost) {
                        dis[next.end] = now.cost + next.cost;
                        pq.add(new Node(next.end, dis[next.end]));
                    }
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