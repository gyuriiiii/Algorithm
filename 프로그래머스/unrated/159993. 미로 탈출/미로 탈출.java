import java.util.ArrayDeque;

class Solution {
    static int h, w;
    static char[][] map;
    static Node start, exit, lever;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static public int solution(String[] maps) {
        int answer = 0;

        h = maps.length;
        w = maps[0].length();

        map = new char[h][w];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);

                if (map[i][j] == 'S') {
                    start = new Node(i, j);
                }
                else if (map[i][j] == 'E') {
                    exit = new Node(i, j);
                }
                else if (map[i][j] == 'L') {
                    lever = new Node(i, j);
                }
            }
        }

        int cnt1 = bfs(start, lever);
        if (cnt1 == 0) return -1;

        int cnt2 = bfs(lever, exit);
        if (cnt2 == 0) return -1;

        answer = cnt1 + cnt2;
        return answer;
    }

    private static int bfs(Node start, Node end) {
        int answer = 0;

        ArrayDeque<Node> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[h][w];
        int[][] cnt = new int[h][w];

        dq.add(start);
        visited[start.x][start.y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.x == end.x && now.y == end.y) {
                answer += cnt[end.x][end.y];
                return answer;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == 'X') {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                    cnt[nx][ny] = cnt[now.x][now.y] + 1;
                }
            }
        }
        return answer;
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