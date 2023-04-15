import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] room;
    static int r, c, d;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        room = new int[N][M];

        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt(); // 로봇 청소기가 바라보는 방향

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = sc.nextInt();
            }
        }

        while (true) {
            step1(r, c);

            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (step2()) {
                int nr = 0;
                int nc = 0;

                if (d == 0 || d == 1) { // 위쪽이나, 오른쪽을 바라보는 경우
                    nr = r + dx[d + 2];
                    nc = c + dy[d + 2];
                }
                else { // 아래쪽이나, 왼쪽 바라보는 경우
                    nr = r + dx[d - 2];
                    nc = c + dy[d - 2];
                }

                // room 벗어난 경우 => 작동 멈추기
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    break;
                }

                // 벽인 경우 => 작동 멈추기
                if (room[nr][nc] == 1) {
                    break;
                }

                // 후진 가능한 경우 한 칸 후진하고, 1번으로 돌아가기
                r = nr;
                c = nc;
            }

            // 현재 칸의 주변  4칸 중 청소되지 않은 빈 칸이 있는 경우
            else {
                // 반시계 방향으로 회전
                switch (d) {
                    case 0:
                        d = 3;
                        break;
                    case 1:
                        d = 0;
                        break;
                    case 2:
                        d = 1;
                        break;
                    case 3:
                        d = 2;
                        break;
                }

                // 바라보는 방향 기준으로 앞족 칸이 청소되지 않은 빈 칸인 경우, 한 칸 전진
                if (room[r + dx[d]][c + dy[d]] == 0) {
                    r = r + dx[d];
                    c = c + dy[d];
                }
            }

        }
        System.out.println(cnt);
    }

    // 청소되지 않은 빈 칸 있는 지 검사
    private static boolean step2() {
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            // 청소되지 않은 빈칸 있는 경우
            if (room[nx][ny] == 0) {
                return false;
            }
        }
        return true;
    }

    // 현재 칸이 아직 청소되지 않은 경우, 현재 칸 청소
    private static void step1(int r, int c) {
        if (room[r][c] == 0) {
            room[r][c] = -1;
            cnt++;
        }
    }
}