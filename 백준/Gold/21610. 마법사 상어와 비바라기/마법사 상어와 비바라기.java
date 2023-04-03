import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int[] dx = new int[]{0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = new int[]{0, -1, -1, 0, 1, 1, 1, 0, -1};

    static int N, M;
    static int[][] map;

    static ArrayDeque<int[]> cloud;
    static boolean[][] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        cloud = new ArrayDeque<>(); // 구름 위치 큐
        cloud.add(new int[]{N, 1});
        cloud.add(new int[]{N, 2});
        cloud.add(new int[]{N - 1, 1});
        cloud.add(new int[]{N - 1, 2});

        // 구름 위치 이동 정보 d[i], s[i]
        for (int i = 0; i < M; i++) {
            rain(sc.nextInt(), sc.nextInt());
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result);
    }

    // 구름 이동 후, 각 구름에서 비 내려서 각 칸의 물 양 + 1
    private static void rain(int d, int s) {
        visited = new boolean[N + 1][N + 1];

        // 구름 위치 변경
        for (int i = 0; i < s; i++) {
            int size = cloud.size();

            for (int j = 0; j < size; j++) {
                int nextx = cloud.peekFirst()[0] + dx[d];
                int nexty = cloud.peekFirst()[1] + dy[d];

                if (nextx < 1 || nextx > N) {
                    if (nextx < 1) {
                        nextx = N - nextx;
                    }
                    else {
                        nextx = nextx - N;
                    }
                }

                if (nexty < 1 || nexty > N) {
                    if (nexty < 1) {
                        nexty = N - nexty;
                    }
                    else {
                        nexty = nexty - N;
                    }
                }

                cloud.addLast(new int[]{nextx, nexty}); // 구름 위치 이동
                cloud.pollFirst(); // 기존 구름 제거
            }
        }

        // 구름 있던 곳 표시
        int size = cloud.size();
        for (int i = 0; i < size; i++) {
            visited[cloud.peekFirst()[0]][cloud.peekFirst()[1]] = true;
            cloud.addLast(cloud.pollFirst());
        }

        // 구름 위치 복사
        ArrayDeque<int[]> cloudTmp = new ArrayDeque<>(); // 구름 위치 큐
        int cloudSize = cloud.size();
        for (int i = 0; i < cloudSize; i++) {
            cloudTmp.add(cloud.peekFirst());
            cloud.addLast(cloud.pollFirst());
        }

        // 구름 있는 칸 바구니에 저장된 물 + 1
        while (!cloudTmp.isEmpty()) {
            int cx = cloudTmp.peekFirst()[0];
            int cy = cloudTmp.peekFirst()[1];
            cloudTmp.pollFirst();

            map[cx][cy] += 1;
        }

        copyWater();

        ArrayDeque<int[]> cloudTmp2 = new ArrayDeque<>(); // 구름 위치 

        // 구름 있었던 칸 제외한 나머지 칸 중 물 양 2 이상인 곳 구름 생김
        // 구름 생기면 물 양 -2
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 구름 있던 칸 제외한 칸
                if (map[i][j] >= 2) {
                    if (!visited[i][j]) {
                        // 구름 생김
                        cloudTmp2.add(new int[]{i, j});

                        // 물 양 -2
                        map[i][j] -= 2;
                    }
                }
            }
        }
        cloud.clear();

        while (!cloudTmp2.isEmpty()) {
            cloud.add(cloudTmp2.pollFirst());
        }
    }

    // 물복사버그 - 대각선 방향으로 거리가 1인 칸에 물 있는 바구니 수만큼 (r,c)에 있는 바구니 물 양 증가
    private static void copyWater() {
        int cloudSize = cloud.size();

        for (int i = 0; i < cloudSize; i++) {
            int cnt = 0; // 바구니 개수

            int cloudx = cloud.peekFirst()[0];
            int cloudy = cloud.peekFirst()[1];

            // 대각선 방향 물 있는 바구니 개수
            for (int j = 2; j <= 8; j += 2) {
                if (cloudx + dx[j] < 1 || cloudx + dx[j] > N || cloudy + dy[j] < 1 || cloudy + dy[j] > N) {
                    continue;
                }

                if (map[cloudx + dx[j]][cloudy + dy[j]] > 0) {
                    cnt++;
                }
                ;
            }

            // 물 있는 바구니 수만큼 해당 바구니 물 양 증가
            map[cloudx][cloudy] += cnt;

            cloud.addLast(cloud.pollFirst());
        }
    }
}