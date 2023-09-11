import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    static ArrayList<Node>[] list;
    static int[] dis;
    static final int MAX = Integer.MAX_VALUE;

    static public int solution(int N, int[][] road, int K) {
        int answer = 0;

        dis = new int[N + 1];
        Arrays.fill(dis, MAX);

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int s = road[i][0];
            int e = road[i][1];
            int w = road[i][2];
            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }

        dijkstra(1);

        for (int i = 1; i <= N; i++) {
            if (dis[i] <= K) {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }

    private static void dijkstra(int a) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        pq.add(new Node(a, 0));
        dis[a] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : list[now.end]) {
                if (dis[next.end] > dis[now.end] + next.cost) {
                    dis[next.end] = dis[now.end] + next.cost;
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