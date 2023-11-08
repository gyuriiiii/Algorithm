import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int x1, x2, y1, y2;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static ArrayDeque<Node> wave = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        x1 = sc.nextInt();
        y1 = sc.nextInt();
        x2 = sc.nextInt();
        y2 = sc.nextInt();

        map = new char[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = s.charAt(j);
            }
        }

        int answer = 0;

        while (true) {
            if (map[x2][y2] == 'X') {
                break;
            }
            bfs(x1, y1);
            answer++;
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        if (wave.isEmpty()) {
            wave.add(new Node(x, y));
            visited[x][y] = true;
        }

        ArrayDeque<Node> dq = new ArrayDeque<>();
        copyWave(dq);

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x;
                int ny = now.y;

                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    // 범위 벗어난 경우
                    if (!inRange(nx, ny)) {
                        break;
                    }

                    // 이미 방문한 경우
                    if(visited[nx][ny]) {
                        break;
                    }

                    visited[nx][ny] = true;

                    // 범인 만난 경우 => X 로 변경
                    if (map[nx][ny] == '#') {
                        map[nx][ny] = 'X';
                        return;
                    }

                    else if (map[nx][ny] == '0') {
                        dq.add(new Node(nx, ny));
                        wave.add(new Node(nx, ny));
                    }

                    else if (map[nx][ny] == '1') {
                        map[nx][ny] = '0';
                        wave.add(new Node(nx, ny));
                        break;
                    }
                }
            }
        }
    }

    private static void copyWave(ArrayDeque<Node> dq) {
        while (!wave.isEmpty()) {
            dq.add(wave.pollLast());
        }
    }

    private static boolean inRange(int x, int y) {
        if (x < 1 || y < 1 || x > N || y > M) {
            return false;
        }
        return true;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}