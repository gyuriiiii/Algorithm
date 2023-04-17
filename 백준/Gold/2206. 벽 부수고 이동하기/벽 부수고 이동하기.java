import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static boolean[][][] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N + 1][M + 1];

        visited = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            int idx = 0;

            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(idx++);
            }
        }
        System.out.println(bfs(new Node(1, 1, 1, 0)));
    }

    private static int bfs(Node node) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(node);
        visited[node.x][node.y][0] = true;
        visited[node.x][node.y][1] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.x == N && now.y == M) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 1 || ny < 1 || nx >= N + 1 || ny >= M + 1) continue;

                // 다음 이동할 곳이 벽이 아닌 경우
                if (map[nx][ny] == '0') {
                    if (!visited[nx][ny][now.broken]) {
                        visited[nx][ny][now.broken] = true;
                        dq.add(new Node(nx, ny, now.cnt + 1, now.broken));
                    }
                }

                // 다음 이동할 곳이 벽인 경우
                else if (map[nx][ny] == '1') {
                    if (now.broken == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true; // 이동할 벽 부수기
                        dq.add(new Node(nx, ny, now.cnt + 1, 1));
                    }
                }
            }
        }
        return -1;
    }

    public static class Node {
        int x;
        int y;
        int cnt; // 거리
        int broken; // 부숨 여부 (0=부수지 X, 1=부숨)

        public Node(int x, int y, int cnt, int broken) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.broken = broken;
        }
    }
}