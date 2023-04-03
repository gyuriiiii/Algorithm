import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;

    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 집의 크기
        map = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(1, 2, 0);
        System.out.println(cnt);
    }

    private static void dfs(int x, int y, int direction) {
        if (x == N && y == N) {
            cnt++;
            return;
        }

        // 가로 방향
        if (direction == 0) {
            if (y + 1 <= N && map[x][y + 1] == 0) { // 오른쪽으로 이동
                dfs(x, y + 1, 0);
            }
        }
        // 세로 방향
        else if (direction == 1) {
            if (x + 1 <= N && map[x + 1][y] == 0) { // 아래로 이동
                dfs(x + 1, y, 1);
            }
        }
        // 대각선 방향
        else if (direction == 2) {
            if (y + 1 <= N && map[x][y + 1] == 0) { // 오른쪽으로 이동
                dfs(x, y + 1, 0);
            }
            if (x + 1 <= N && map[x + 1][y] == 0) { // 아래로 이동
                dfs(x + 1, y, 1);
            }

        }

        // 대각선으로 이동
        if (x + 1 <= N && y + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }
}