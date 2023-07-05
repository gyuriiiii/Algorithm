import java.util.ArrayDeque;

public class Solution {
    static Node start, end;
    static int n, m;
    static int[][] cnt;
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static public int solution(String[] board) {
        n = board.length;
        m = board[0].length();

        cnt = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    start = new Node(i, j);
                }
                else if (board[i].charAt(j) == 'G') {
                    end = new Node(i, j);
                }
            }
        }

        return bfs(start, board);
    }

    private static int bfs(Node start, String[] board) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start.x][start.y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.x == end.x && now.y == end.y) {
                return cnt[end.x][end.y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x;
                int ny = now.y;

                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    // map 끝에 도달한 경우 or 장애물 만난 경우
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx].charAt(ny) == 'D') {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                    cnt[nx][ny] = cnt[now.x][now.y] + 1;
                }
            }
        }

        return -1;
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