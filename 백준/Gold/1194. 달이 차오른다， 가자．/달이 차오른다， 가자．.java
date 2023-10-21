import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N, M;
    static char[][] map;
    static Node start;
    static boolean[][] exit;
    static boolean[][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        exit = new boolean[N][M];
        visited = new boolean[N][M][64];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);

                // 현위치
                if (map[i][j] == '0') {
                    start = new Node(i, j, 0, 0);
                }
                // 출구
                else if (map[i][j] == '1') {
                    exit[i][j] = true;
                }
            }
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(start.x, start.y, 0, 0));
        visited[start.x][start.y][0] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (exit[now.x][now.y]) {
                answer = now.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '#') {
                    continue;
                }

                // 이미 탐색한 경우
                if (visited[nx][ny][now.key]) {
                    continue;
                }

                // 열쇠 => key 추가
                if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                    int newKey = 1 << (map[nx][ny] - 'a');
                    newKey = now.key | newKey; // 기존 key와 OR 연산

                    if (!visited[nx][ny][newKey]) {
                        visited[nx][ny][newKey] = true;
                        dq.add(new Node(nx, ny, now.cnt + 1, newKey));
                    }
                }

                // 문 => 열쇠 없는 경우, 이동 불가
                else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                    int door = 1 << (map[nx][ny] - 'A');

                    // 문에 해당되는 key 가 있는 경우
                    if ((now.key & door) > 0) {
                        visited[nx][ny][now.key] = true;
                        dq.add(new Node(nx, ny, now.cnt + 1, now.key));
                    }
                }

                // 빈칸
                else {
                    visited[nx][ny][now.key] = true;
                    dq.add(new Node(nx, ny, now.cnt + 1, now.key));
                }
            }
        }
    }

    private static class Node {
        int x;
        int y;
        int cnt;
        int key;

        public Node(int x, int y, int cnt, int key) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }
    }
}