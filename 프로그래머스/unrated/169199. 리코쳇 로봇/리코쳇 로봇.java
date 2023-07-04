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

                cnt[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(start, board);

        if (cnt[end.x][end.y] == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return cnt[end.x][end.y];
        }
    }

    private static void bfs(Node start, String[] board) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(start);
        cnt[start.x][start.y] = 0;
        visited[start.x][start.y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x;
                int ny = now.y;

                if (nx + dx[i] < 0 || ny + dy[i] < 0 || nx + dx[i] >= n || ny + dy[i] >= m) {
                    continue;
                }

                if (nx + dx[i] == end.x && ny + dy[i] == end.y) {
                    nx = nx + dx[i] + dx[i];
                    ny = ny + dy[i] + dy[i];

                    if (board[nx].charAt(ny) == 'D' || nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        cnt[end.x][end.y] = Math.min(cnt[end.x][end.y], cnt[now.x][now.y] + 1);
                        return;
                    }
                }

                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    // map 끝에 도달한 경우
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        nx -= dx[i];
                        ny -= dy[i];

                        break;
                    }

                    // 장애물 만난 경우
                    if (board[nx].charAt(ny) == 'D') {
                        nx -= dx[i];
                        ny -= dy[i];

                        break;
                    }
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                    cnt[nx][ny] = Math.min(cnt[nx][ny], cnt[now.x][now.y] + 1);
                }
            }
        }
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