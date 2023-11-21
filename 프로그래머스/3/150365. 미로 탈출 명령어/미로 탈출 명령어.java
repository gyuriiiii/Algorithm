import java.util.ArrayDeque;

public class Solution {
    static int N, M;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] op = {"d", "l", "r", "u"};

    static public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        
        boolean[][][] visited = new boolean[n + 1][m + 1][k + 1];

        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y, new StringBuilder()));
        visited[x][y][0] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.x == r && now.y == c) {
                if (now.sb.length() == k) {
                    return now.sb.toString();
                }
            }

            if (now.sb.toString().length() == k) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!inRange(nx, ny)) {
                    continue;
                }

                if (visited[nx][ny][now.sb.toString().length() + 1]) {
                    continue;
                }

                visited[nx][ny][now.sb.toString().length() + 1] = true;
                dq.add(new Node(nx, ny, new StringBuilder(now.sb).append(op[i])));
            }
        }

        return "impossible";
    }

    static public class Node {
        int x;
        int y;
        StringBuilder sb;

        public Node(int x, int y, StringBuilder sb) {
            this.x = x;
            this.y = y;
            this.sb = sb;
        }
    }

    static public boolean inRange(int x, int y) {
        if (x < 1 || y < 1 || x > N || y > M)
            return false;
        return true;
    }
}