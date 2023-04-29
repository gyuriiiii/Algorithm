import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            map[r][c] = 1; // 음식물 떨어진 좌표
        }

        int max = 0; // 가장 큰 음식물 크기

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (map[i][j] == 1) {
                    if (!visited[i][j]) {
                        max = Math.max(max, bfs(i, j));
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static int bfs(int x, int y) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        
        dq.add(new Node(x, y));
        visited[x][y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 1 || ny < 1 || nx >= N + 1 || ny >= M + 1) {
                    continue;
                }

                if (map[nx][ny] > 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                    map[x][y]++;
                }
            }
        }
        return map[x][y];
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}