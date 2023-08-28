import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map, tmpMap;
    static int[] direct;
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        direct = new int[5];

        backtracking(0, 5);
        System.out.println(max);
    }

    private static void backtracking(int cnt, int depth) {
        if (cnt == depth) {
            move();
            return;
        }

        for (int i = 0; i < 4; i++) {
            direct[cnt] = i;
            backtracking(cnt + 1, depth);
        }
    }

    private static void move() {
        tmpMap = new int[N][N];
        copyMap();

        for (int i = 0; i < direct.length; i++) {
            visited = new boolean[N][N];
            
            int d = direct[i];

            // 상
            if (d == 0) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        transfer(j, k, direct[i]);
                    }
                }
            }
            // 하
            else if (d == 1) {
                for (int j = N - 1; j >= 0; j--) {
                    for (int k = 0; k < N; k++) {
                        transfer(j, k, direct[i]);
                    }
                }
            }
            // 좌
            else if (d == 2) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        transfer(k, j, direct[i]);
                    }
                }
            }
            // 우
            else if (d == 3) {
                for (int j = N - 1; j >= 0; j--) {
                    for (int k = 0; k < N; k++) {
                        transfer(k, j, direct[i]);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, tmpMap[i][j]);
            }
        }
    }

    private static void transfer(int x, int y, int d) {
        if (tmpMap[x][y] == 0) {
            return;
        }

        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                return;
            }

            if (visited[nx][ny]) {
                return;
            }

            // 같은 수인 경우 => 합치기
            if (tmpMap[x][y] == tmpMap[nx][ny]) {
                visited[nx][ny] = true;
                tmpMap[nx][ny] *= 2;
                tmpMap[x][y] = 0;
                return;
            }

            // 같은 수가 아닌 경우
            else if (tmpMap[nx][ny] != 0) {
                return;
            }

            tmpMap[nx][ny] = tmpMap[x][y];
            tmpMap[x][y] = 0;
            x = nx;
            y = ny;
        }
    }

    private static void copyMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
    }
}