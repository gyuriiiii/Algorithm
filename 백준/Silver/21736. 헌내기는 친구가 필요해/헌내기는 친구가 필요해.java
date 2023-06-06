import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    
    static int answer = 0;
    static Node start;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'I') {
                    start = new Node(i, j);
                }
            }
        }

        bfs(start);

        if (answer == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(answer);
    }

    private static void bfs(Node start) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start.x][start.y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (map[now.x][now.y] == 'P') {
                answer++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (map[nx][ny] == 'X') {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny));
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