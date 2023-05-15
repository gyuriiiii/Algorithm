import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static ArrayDeque<Node> teamDq = new ArrayDeque<>();
    static ArrayDeque<Node> enemyDq = new ArrayDeque<>();
    static int team = 0;
    static int enemy = 0;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'W') { // 아군
                    teamDq.add(new Node(i, j));
                }
                else { // 적군
                    enemyDq.add(new Node(i, j));
                }
            }
        }

        while (!teamDq.isEmpty()) {
            Node now = teamDq.poll();

            if (!visited[now.x][now.y]) {
                bfs(now.x, now.y, 'W');
            }
        }

        while (!enemyDq.isEmpty()) {
            Node now = enemyDq.poll();

            if (!visited[now.x][now.y]) {
                bfs(now.x, now.y, 'B');
            }
        }
        System.out.println(team);
        System.out.println(enemy);
    }

    private static void bfs(int x, int y, char color) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y));
        visited[x][y] = true;

        int cnt = 1;
        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                if (map[nx][ny] != color) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                    cnt++;
                }
            }
        }

        if (color == 'W') {
            team += (Math.pow(cnt, 2));
        }
        else {
            enemy += (Math.pow(cnt, 2));
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}