public class Solution {
    static int N, M, X, Y, R, C, K;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] op = {"d", "l", "r", "u"};
    static StringBuilder sb = new StringBuilder();
    static boolean[][][] visited;
    static String answer = "";

    static public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        X = x;
        Y = y;
        R = r;
        C = c;
        K = k;

        visited = new boolean[N + 1][M + 1][K + 1];
        visited[x][y][0] = true;

        dfs(x, y, 0);

        if (answer.equals("")) {
            return "impossible";
        }
        return answer;
    }

    private static void dfs(int x, int y, int cnt) {
        if (!answer.equals("")) {
            return;
        }

        if (x == R && y == C && cnt == K) {
            answer = sb.toString();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny) || cnt + 1 > K) {
                continue;
            }

            if (visited[nx][ny][cnt + 1]) {
                continue;
            }

            visited[nx][ny][cnt + 1] = true;
            sb.append(op[i]);
            dfs(nx, ny, cnt + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static public boolean inRange(int x, int y) {
        if (x < 1 || y < 1 || x > N || y > M)
            return false;
        return true;
    }
}