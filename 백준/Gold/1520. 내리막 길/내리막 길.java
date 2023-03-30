import java.util.Scanner;

public class Main {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int M, N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        dp[M - 1][N - 1] = 1; // 초기화

        dfs(0, 0);
        System.out.println(dp[0][0]);
    }

    private static int dfs(int nowx, int nowy) {
        if (dp[nowx][nowy] > -1) { // 이미 방문
            return dp[nowx][nowy];
        }

        dp[nowx][nowy] = 0;

        for (int i = 0; i < 4; i++) {
            int nextx = nowx + dx[i];
            int nexty = nowy + dy[i];

            if (nextx < 0 || nexty < 0 || nextx >= M || nexty >= N) {
                continue;
            }

            if (map[nowx][nowy] > map[nextx][nexty]) { // 높이가 더 낮은 지점으로만 이동
                dp[nowx][nowy] += dfs(nextx, nexty);
            }
        }

        return dp[nowx][nowy];
    }
}