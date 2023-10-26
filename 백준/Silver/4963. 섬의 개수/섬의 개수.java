import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int sum = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        sum++;
                    }
                }
            }

            System.out.println(sum);
        }
    }

    private static void bfs(int x, int y) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y));
        visited[x][y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    continue;
                }

                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                }
            }
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}