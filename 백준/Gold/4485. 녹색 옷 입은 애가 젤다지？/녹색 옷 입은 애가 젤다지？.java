import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N;
    static final int INF = 987654321;
    static int[][] weight;
    static int[][] dis;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        int idx = 1;

        while (true) {
            N = sc.nextInt();
            if (N == 0) break;

            weight = new int[N][N];
            dis = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    weight[i][j] = sc.nextInt();
                    dis[i][j] = INF;
                }
            }

            dijkstra(0, 0);
            sb.append("Problem " + idx++ + ": " + dis[N - 1][N - 1]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

        pq.add(new Node(x, y, weight[x][y]));
        dis[x][y] = weight[x][y];

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                int cost = now.cost + weight[nx][ny];
                if (dis[nx][ny] > cost) {
                    dis[nx][ny] = cost;
                    pq.add(new Node(nx, ny, cost));
                }
            }
        }
    }

    static public class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}