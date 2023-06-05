import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    static int N;
    static ArrayList<Node> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, time));
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            int sToN = dijkstra(i, X);
            int NtoS = dijkstra(X, i);

            int route = sToN + NtoS;
            max = Math.max(max, route);
        }

        System.out.println(max);
    }

    private static int dijkstra(int start, int end) {
        int[] dis = new int[N + 1];
        Arrays.fill(dis, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.time, o2.time)));
        pq.add(new Node(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dis[now.end] < now.time) {
                continue;
            }

            for (Node next : list[now.end]) {
                if (dis[next.end] > now.time + next.time) {
                    dis[next.end] = now.time + next.time;
                    pq.add(new Node(next.end, dis[next.end]));
                }
            }
        }
        return dis[end];
    }

    static public class Node {
        int end;
        int time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
}