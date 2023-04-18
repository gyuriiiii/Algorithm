import java.util.Scanner;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][][][] changed;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new char[N][N];
        changed = new boolean[N][N][N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    if (map[i][j] != map[nx][ny]) {
                        if (!changed[i][j][nx][ny] && !changed[nx][ny][i][j]) {
                            change(new int[]{i, j}, new int[]{nx, ny});
                            changed[i][j][nx][ny] = changed[nx][ny][i][j] = true;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void change(int[] c1, int[] c2) {
        // 인접한 칸 교환
        char tmp = map[c1[0]][c1[1]];
        map[c1[0]][c1[1]] = map[c2[0]][c2[1]];
        map[c2[0]][c2[1]] = tmp;

        check_arr();

        // 교환했던 칸 되돌리기
        char tmp2 = map[c1[0]][c1[1]];
        map[c1[0]][c1[1]] = map[c2[0]][c2[1]];
        map[c2[0]][c2[1]] = tmp2;
    }

    private static void check_arr() {
        // 가로 중 가장 큰 사탕 개수 찾기
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }

                answer = Math.max(answer, cnt);
            }
        }

        // 세로 중 가장 큰 사탕 개수 찾기
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }

                answer = Math.max(answer, cnt);
            }
        }
    }
}