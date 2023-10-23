import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int n, MAX_CHANGE;
    static char[][] map;
    static boolean[][][] visited;
    static int answer = Integer.MAX_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        MAX_CHANGE = n * n - 2;
        map = new char[n][n];

        visited = new boolean[n][n][MAX_CHANGE + 1];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        bfs(0, 0);
        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y, 0));
        visited[x][y][0] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.change >= MAX_CHANGE) {
                continue;
            }

            if (now.x == n - 1 && now.y == n - 1) {
                answer = Math.min(answer, now.change);
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 방 범위 벗어난 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                // 이미 방문한 경우
                if (visited[nx][ny][now.change]) continue;

                // 흰방인 경우
                if (map[nx][ny] == '1') {
                    visited[nx][ny][now.change] = true;
                    dq.add(new Node(nx, ny, now.change));
                }

                // 검은방인 경우 => 흰방으로 변경해야 함
                else if (map[nx][ny] == '0') {
                    if (!visited[nx][ny][now.change + 1]) {
                        visited[nx][ny][now.change + 1] = true;
                        dq.add(new Node(nx, ny, now.change + 1));
                    }
                }
            }
        }
    }

    private static class Node {
        int x;
        int y;
        int change;

        public Node(int x, int y, int change) {
            this.x = x;
            this.y = y;
            this.change = change;
        }
    }
}