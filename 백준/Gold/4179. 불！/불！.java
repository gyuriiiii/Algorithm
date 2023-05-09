import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[][] cnt;

    static ArrayDeque<Node> fire;
    static Node start;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        cnt = new int[R][C];
        visited = new boolean[R][C];
        fire = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'J') { // 시작 위치
                    start = new Node(i, j);
                }
                if (map[i][j] == 'F') { // 불
                    fire.add(new Node(i, j));
                }
            }
        }

        bfs(start);
        if (result == 0) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(result);
        }
    }

    private static void bfs(Node start) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(start.x, start.y));

        while (!dq.isEmpty()) {
            int size = dq.size();

            for (int i = 0; i < size; i++) {
                Node now = dq.poll();
                
                if (map[now.x][now.y] == 'F') {
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    // 미로 탈출 => 종료
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                        result = cnt[now.x][now.y] + 1;
                        return;
                    }

                    // 벽이거나 불이 난 경우 => 이동 불가
                    if (map[nx][ny] == '#' || map[nx][ny] == 'F') {
                        continue;
                    }

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dq.add(new Node(nx, ny));
                        cnt[nx][ny] = cnt[now.x][now.y] + 1;
                    }
                }
            }
            fire();
        }
    }

    private static void fire() {
        int size = fire.size();

        for (int i = 0; i < size; i++) {
            Node now = fire.poll();

            for (int j = 0; j < 4; j++) {
                int nx = now.x + dx[j];
                int ny = now.y + dy[j];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }

                if (map[nx][ny] == '#' || map[nx][ny] == 'F') {
                    continue;
                }

                map[nx][ny] = 'F';
                fire.add(new Node(nx, ny));
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