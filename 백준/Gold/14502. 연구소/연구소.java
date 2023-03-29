import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] map;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static ArrayDeque<int[]> virus = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 2) { // 바이러스 있는 경우 virus 큐에 추가
                    virus.add(new int[]{i, j});
                }
            }
        }

        ArrayDeque<int[]> block = new ArrayDeque<>(); // 벽
        int max = Integer.MIN_VALUE;

        // 벽 3개 세우기
        for (int i = 0; i < N * M - 2; i++) {
            if (map[i / M][i % M] != 0) continue;
            block.add(new int[]{i / M, i % M});

            for (int j = i + 1; j < N * M - 1; j++) {
                if (map[j / M][j % M] != 0) continue;
                block.add(new int[]{j / M, j % M});

                for (int k = j + 1; k < N * M; k++) {
                    if (map[k / M][k % M] != 0) continue;
                    block.add(new int[]{k / M, k % M});

                    max = Integer.max(max, bfs(block));
                    block.pollLast();
                }
                block.pollLast();
            }
            block.pollLast();
        }
        System.out.println(max);
    }

    private static int bfs(ArrayDeque<int[]> block) {
        // map 복사
        int[][] map2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map2[i][j] = map[i][j];
            }
        }

        // block 큐에 있는 위치에 벽 세우기
        for (int[] b : block) {
            map2[b[0]][b[1]] = 1;
        }

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for (int[] v : virus) {
            dq.add(v);
        }

        // 바이러스 있는 곳의 인접한 곳 감염시키기
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int curx = cur[0];
            int cury = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextx = curx + dx[i];
                int nexty = cury + dy[i];

                // map 벗어난 경우
                if (nextx < 0 || nexty < 0 || nextx >= N || nexty >= M) {
                    continue;
                }

                // 아직 방문하지 않은 경우만 감염시키기
                if (map2[nextx][nexty] == 0) {
                    map2[nextx][nexty] = 2;

                    dq.add(new int[]{nextx, nexty}); // 바이러스 큐에 추가
                }
            }
        }

        // 안전영역 개수 구하기
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map2[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}