import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int R, C, T;
    static int[][] map;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static ArrayDeque<int[]> dusts = new ArrayDeque<>(); // 미세먼지 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();

        map = new int[R + 1][C + 1];

        ArrayList<int[]> airCleaner = new ArrayList<>();

        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == -1) { // 공기 청정기 위치
                    airCleaner.add(new int[]{i, j});
                }
            }
        }

        // 위쪽, 아래쪽 공기청정기 위치
        int[] up = airCleaner.get(0);
        int[] down = airCleaner.get(1);

        for (int i = 0; i < T; i++) {
            for (int j = 1; j < R + 1; j++) {
                for (int k = 1; k < C + 1; k++) {
                    if (map[j][k] > 0) {
                        dusts.addLast(new int[]{j, k, map[j][k] / 5});
                    }
                }
            }

            // 미세먼지 확산
            dustSpread(dusts);
            // 공기청정기 작동
            cleanAir(up, down);
        }

        int sum = 0; // 구사과 방에 남아있는 미세먼지 양
        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    private static void dustSpread(ArrayDeque<int[]> dusts) {
        int size = dusts.size();

        for (int i = 0; i < size; i++) {
            int[] dust = dusts.poll();

            int dustx = dust[0];
            int dusty = dust[1];
            int spread = dust[2];

            int cnt = 0; // 확산시킨 칸 개수

            for (int j = 0; j < 4; j++) {
                int nx = dustx + dx[j];
                int ny = dusty + dy[j];

                // 칸 벗어난 경우
                if (nx < 1 || ny < 1 || nx >= R + 1 || ny >= C + 1) {
                    continue;
                }

                // 공기청정기 있는 경우
                if (map[nx][ny] == -1) {
                    continue;
                }

                map[nx][ny] += spread; // 미세먼지 확산
                cnt++;
            }
            map[dustx][dusty] -= (spread * cnt);
        }
    }

    private static void cleanAir(int[] up, int[] down) {
        // 위쪽 공기청정기 작동
        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<ArrayDeque<Integer>> mid = new ArrayDeque<>();
        ArrayDeque<Integer> right = new ArrayDeque<>();

        for (int i = 1; i <= up[0]; i++) {
            left.add(map[i][1]);

            ArrayDeque<Integer> midQueue = new ArrayDeque<>();
            for (int j = 2; j < C; j++) {
                midQueue.add(map[i][j]);
            }
            mid.add(midQueue);

            right.add(map[i][C]);
        }

        mid.peekLast().addFirst(left.pollLast());
        right.addLast(mid.peekLast().pollLast());
        mid.peekFirst().addLast(right.pollFirst());
        left.addFirst(mid.peekFirst().pollFirst());

        // map 변경
        for (int i = 1; i <= up[0]; i++) {
            map[i][1] = left.pollFirst();

            ArrayDeque<Integer> dq = mid.pollFirst();
            while (!dq.isEmpty()) {
                for (int j = 2; j < C; j++) {
                    map[i][j] = dq.pollFirst();
                }
            }

            map[i][C] = right.pollFirst();
        }

        map[up[0]][1] = -1;
        map[up[0]][2] = 0;

        // 아래쪽 공기청정기 작동
        left = new ArrayDeque<>();
        mid = new ArrayDeque<>();
        right = new ArrayDeque<>();

        for (int i = down[0]; i <= R; i++) {
            left.add(map[i][1]);

            ArrayDeque<Integer> midQueue = new ArrayDeque<>();
            for (int j = 2; j < C; j++) {
                midQueue.add(map[i][j]);
            }
            mid.add(midQueue);

            right.add(map[i][C]);
        }

        mid.peekFirst().addFirst(left.pollFirst());
        right.addFirst(mid.peekFirst().pollLast());
        mid.peekLast().addLast(right.pollLast());
        left.addLast(mid.peekLast().pollFirst());

        // map 변경
        for (int i = down[0]; i <= R; i++) {
            map[i][1] = left.pollFirst();

            ArrayDeque<Integer> dq = mid.pollFirst();
            while (!dq.isEmpty()) {
                for (int j = 2; j < C; j++) {
                    map[i][j] = dq.pollFirst();
                }
            }

            map[i][C] = right.pollFirst();
        }

        map[down[0]][1] = -1;
        map[down[0]][2] = 0;
    }
}