import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static ArrayList<Node>[] list;
    static int[] dis;
    static boolean[] visited;
    static final int INF = 987654321;
    static int v1, v2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int E = sc.nextInt();

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        dis = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        v1 = sc.nextInt();
        v2 = sc.nextInt();

        long result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);

        long result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        if (result1 >= INF && result2 >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(result1, result2));
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dis, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        pq.add(new Node(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(visited[now.end]) {
                continue;
            }
            visited[now.end] = true;
            
            for (Node next : list[now.end]) {
                if (dis[next.end] > now.cost + next.cost) {
                    dis[next.end] = now.cost + next.cost;
                    pq.add(new Node(next.end, dis[next.end]));
                }
            }
        }

        return dis[end];
    }

    private static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}