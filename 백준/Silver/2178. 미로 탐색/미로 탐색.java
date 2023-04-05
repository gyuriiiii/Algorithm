import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] result;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        result = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();

            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        result[0][0] = 1;
        bfs(0, 0);
        System.out.println(result[N - 1][M - 1]);
    }

    private static void bfs(int x, int y) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        dq.add(new int[]{x, y});
        visited[x][y] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int curx = cur[0];
            int cury = cur[1];

            if (curx == N - 1 && cury == M - 1) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextx = curx + dx[i];
                int nexty = cury + dy[i];

                // map 벗어남
                if (nextx < 0 || nexty < 0 || nextx >= N || nexty >= M) {
                    continue;
                }

                // 이동할 수 없는 칸
                if (map[nextx][nexty] == 0) {
                    continue;
                }

                if (!visited[nextx][nexty]) {
                    dq.add(new int[]{nextx, nexty});
                    visited[nextx][nexty] = true;

                    result[nextx][nexty] = result[curx][cury] + 1;
                }
            }
        }
    }
}