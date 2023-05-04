import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static int[][] cnt;
    static boolean[][] visited;
    static Node start, end;

    static int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); 
        for (int i = 0; i < T; i++) {
            N = sc.nextInt(); 

            map = new int[N][N];
            visited = new boolean[N][N];
            cnt = new int[N][N];

            start = new Node(sc.nextInt(), sc.nextInt());
            end = new Node(sc.nextInt(), sc.nextInt());

            bfs(start);
            System.out.println(cnt[end.x][end.y]);
        }
    }

    private static void bfs(Node start) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(start.x, start.y));
        visited[start.x][start.y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();
            if (now.x == end.x && now.y == end.y) {
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                    cnt[nx][ny] = cnt[now.x][now.y] + 1;
                }
            }
        }
    }

    static public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}