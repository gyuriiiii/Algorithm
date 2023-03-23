import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static ArrayDeque<int[]> virus = new ArrayDeque<>();
    static int N, M;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 2) { // 바이러스 위치
                    virus.addLast(new int[]{i, j});
                }
            }
        }

        ArrayDeque<int[]> block = new ArrayDeque<>();

        int result = 0;

        // 벽 세울 공간 block에 저장
        for (int i = 0; i < N * M - 2; i++) {
            if (map[i / M][i % M] != 0) continue; // 빈 칸 아닌 경우 벽 못 세움
            block.addLast(new int[]{i / M, i % M});

            for (int j = i + 1; j < N * M - 2; j++) {
                if (map[j / M][j % M] != 0) continue;
                block.addLast(new int[]{j / M, j % M});

                for (int k = j + 1; k < N * M; k++) {
                    if (map[k / M][k % M] != 0) continue;
                    block.addLast(new int[]{k / M, k % M});

                    result = Math.max(result, bfs(block));
                    block.pollLast();
                }
                block.pollLast();
            }
            block.pollLast();
        }
        System.out.println(result);
    }

    // 바이러스 정점 인접해있는 곳 감염시키는 bfs
    private static int bfs(ArrayDeque<int[]> block) {
        int[][] map2 = new int[N][M];

        // map 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map2[i][j] = map[i][j];
            }
        }

        // 벽 3개 세우기 (block에 있는 공간)
        for (int[] b : block) {
            map2[b[0]][b[1]] = 1;
        }

        // 바이러스 위치 queue
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int[] v : virus) {
            queue.addLast(new int[]{v[0], v[1]});
        }

        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                // map 밖 벗어난 경우
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                // 바이러스 이미 있는 경우
                if (map2[nx][ny] == 2)
                    continue;

                // 빈 칸인 경우, 바이러스 감염시키기
                if (map2[nx][ny] == 0) {
                    map2[nx][ny] = 2;
                    queue.addLast(new int[]{nx, ny});
                }
            }
        }

        // 안전 영역 크기 구하기
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