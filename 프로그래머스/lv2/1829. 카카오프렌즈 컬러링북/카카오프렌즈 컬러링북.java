import java.util.ArrayDeque;

public class Solution {
    static int M, N;
    static boolean[][] visited;
    static int[][] pictures;
    static int max;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static public int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        pictures = picture;
        visited = new boolean[M][N];
        max = Integer.MIN_VALUE;

        int num = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && pictures[i][j] != 0) {
                    bfs(i, j);
                    num++;
                }
            }
        }

        if (max == Integer.MIN_VALUE) {
            max = 0;
        }

        int[] answer = new int[]{num, max};
        return answer;
    }

    private static void bfs(int x, int y) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y));
        visited[x][y] = true;

        int cnt = 1;
        while (!dq.isEmpty()) {
            Node now = dq.poll();
            int color = pictures[now.x][now.y];

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if (pictures[nx][ny] == color) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
    }

    static public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}