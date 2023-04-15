import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int R, C, T;
    static int[][] map;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static ArrayDeque<int[]> dusts = new ArrayDeque<>(); // 미세먼지 위치
    static ArrayList<int[]> airCleaner = new ArrayList<>(); // 공기청정기 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();

        map = new int[R + 1][C + 1];

        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == -1) { // 공기 청정기 위치
                    airCleaner.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < T; i++) {
            // 미세먼지 위치 확인
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
            cleanAir();
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
        while (!dusts.isEmpty()) {
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

    private static void cleanAir() {
        // 윗쪽 공기청정기 작동
        int up = airCleaner.get(0)[0];  

        for (int i = up - 1; i > 1; i--) { // 아래로
            map[i][1] = map[i - 1][1];
        }
        for (int i = 1; i < C; i++) { // <-
            map[1][i] = map[1][i + 1];
        }
        for (int i = 1; i < up; i++) { // 위로
            map[i][C] = map[i + 1][C];
        }
        for (int i = C; i > 2; i--) { // ->
            map[up][i] = map[up][i - 1];
        }
        map[up][2] = 0; // 공기청정기 쪽은 미세먼지 X

        // 아래쪽 공기청정기 작동
        int down = airCleaner.get(1)[0];

        for (int i = down + 1; i < R; i++) { // 위로
            map[i][1] = map[i + 1][1];
        }
        for (int i = 1; i < C; i++) { // <-
            map[R][i] = map[R][i + 1];
        }
        for (int i = R; i > down; i--) { // 아래로
            map[i][C] = map[i - 1][C];
        }
        for (int i = C; i > 2; i--) { // ->
            map[down][i] = map[down][i - 1];
        }
        map[down][2] = 0;
    }
}