class Solution {
    static String answer = "";
    static StringBuilder sb;

    static char[] op = {'d', 'l', 'r', 'u'};
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};

    static int N, M;
    static int endX, endY;

    static public String solution(int n, int m, int x, int y, int r, int c, int k) {
        sb = new StringBuilder();

        endX = r;
        endY = c;

        N = n;
        M = m;
        
        int distance = dis(x, y, endX, endY);
        if ((k - distance) % 2 == 1 || distance > k) {
            return "impossible";
        }
        
        dfs(x, y, 0, k);
        if (answer.equals("")) {
            return "impossible";
        }
        return answer;
    }

    private static void dfs(int r, int c, int num, int k) {
        if (!answer.equals("")) {
            return;
        }

        if (num + dis(r, c, endX, endY) > k)
            return;

        if (num == k) {
            answer = sb.toString();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx <= N && ny <= M && nx > 0 && ny > 0) {
                sb.append(op[i]);
                dfs(nx, ny, num + 1, k);
                sb.delete(num, num + 1);
            }
        }
    }

    private static int dis(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
}