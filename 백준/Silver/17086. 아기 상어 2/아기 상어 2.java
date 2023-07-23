import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map, tmp;
    static ArrayList<Node> sharks = new ArrayList<>();
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = new int[]{0, 0, -1, 1, -1, -1, 1, 1};

    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1) {
                    sharks.add(new Node(i, j));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    visited = new boolean[N][M];
                    tmp = new int[N][M];
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < M; l++) {
                            tmp[k][l] = Integer.MAX_VALUE;
                        }
                    }

                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y));
        tmp[x][y] = 0;
        visited[x][y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                tmp[nx][ny] = Math.min(tmp[nx][ny], tmp[now.x][now.y] + 1);
                dq.add(new Node(nx, ny));
            }
        }

        int cnt = Integer.MAX_VALUE;

        for (Node shark : sharks) {
            cnt = Math.min(cnt, tmp[shark.x][shark.y]);
        }

        return cnt;
    }

    static private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}