import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int result = 0;

        // 비 양에 따라 안전영역 개수 구하기
        for (int i = 0; i <= max; i++) {
            boolean[][] tmp = new boolean[N][N]; // 잠김 여부 (true - 물에 잠김)
            visited = new boolean[N][N]; // 방문 여부

            int cnt = 0; // 안전영역 개수

            for (int k = 0; k < N; k++) {
                for (int j = 0; j < N; j++) {
                    if (map[k][j] <= i) {
                        tmp[k][j] = true;
                    }
                }
            }

            for (int k = 0; k < N; k++) {
                for (int j = 0; j < N; j++) {
                    if (!tmp[k][j] && !visited[k][j]) {
                        bfs(k, j, tmp);
                        cnt++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }

    private static void bfs(int x, int y, boolean[][] tmp) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        visited[x][y] = true;
        dq.add(new int[]{x, y});

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int curx = cur[0];
            int cury = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextx = curx + dx[i];
                int nexty = cury + dy[i];

                if (nextx < 0 || nexty < 0 || nextx >= N || nexty >= N) { // map 벗어난 경우
                    continue;
                }

                if (tmp[nextx][nexty] || visited[nextx][nexty]) { // 잠겨있거나, 방문한 경우
                    continue;
                }

                visited[nextx][nexty] = true;
                dq.add(new int[]{nextx, nexty});
            }
        }
    }
}