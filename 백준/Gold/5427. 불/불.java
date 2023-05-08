import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int w, h;
    static char[][] map;
    static boolean[][] visited;
    static int[][] cnt;
    static int result;

    static Node start;
    static ArrayDeque<Node> fire;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            w = sc.nextInt();
            h = sc.nextInt();
            result = 0;

            map = new char[h][w];
            visited = new boolean[h][w];
            cnt = new int[h][w];

            fire = new ArrayDeque<>();

            for (int j = 0; j < h; j++) {
                String s = sc.next();
                for (int k = 0; k < w; k++) {
                    map[j][k] = s.charAt(k);

                    if (map[j][k] == '@') { // 시작 위치
                        start = new Node(j, k);
                    }

                    if (map[j][k] == '*') { // 불 위치
                        fire.add(new Node(j, k));
                    }
                }
            }

            bfs(start);

            if (result == 0) {
                sb.append("IMPOSSIBLE").append("\n");
            }
            else {
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void bfs(Node start) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(start.x, start.y));
        visited[start.x][start.y] = true;

        while (!dq.isEmpty()) {
            int size = dq.size();

            nextFire();

            for (int a = 0; a < size; a++) {
                Node now = dq.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    // 빌딩 밖으로 탈출한 경우 => 종료
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        result = cnt[now.x][now.y] + 1;
                        return;
                    }

                    // 벽, 불이 옮겨진 칸 => 이동 불가
                    if (map[nx][ny] == '#' || map[nx][ny] == '*') {
                        continue;
                    }

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dq.add(new Node(nx, ny));
                        cnt[nx][ny] = cnt[now.x][now.y] + 1;
                    }
                }
            }

        }
    }

    private static void nextFire() {
        int size = fire.size();

        for (int i = 0; i < size; i++) {
            Node now = fire.poll();

            for (int j = 0; j < 4; j++) {
                int nx = now.x + dx[j];
                int ny = now.y + dy[j];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    continue;
                }

                if (map[nx][ny] == '#' || map[nx][ny] == '*') {
                    continue;
                }

                map[nx][ny] = '*';
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