import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static ArrayList<Node>[] list;
    static int[] dis;
    static boolean[] visited;
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cow = sc.nextInt();
            list[a].add(new Node(b, cow));
            list[b].add(new Node(a, cow));
        }

        dis = new int[N + 1];
        Arrays.fill(dis, INF);

        visited = new boolean[N + 1];

        dijkstra(1);
        System.out.println(dis[N]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        pq.add(new Node(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) {
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