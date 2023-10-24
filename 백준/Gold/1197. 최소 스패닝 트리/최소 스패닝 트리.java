import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static ArrayList<Node>[] adjList;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        adjList = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        visited = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            adjList[A].add(new Node(B, C));
            adjList[B].add(new Node(A, C));
        }

        prim(1);
        System.out.println(answer);
    }

    private static void prim(int idx) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        pq.add(new Node(idx, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;
                answer += now.cost;

                for (Node next : adjList[now.end]) {
                    if (!visited[next.end]) {
                        pq.add(new Node(next.end, next.cost));
                    }
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