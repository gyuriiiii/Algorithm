import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map, dis;
    static boolean[][] visited;
    static Node end;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dis = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dis[i][j] = -1;

                if (map[i][j] == 0) {
                    dis[i][j] = 0;
                }
                else if (map[i][j] == 2) {
                    end = new Node(i, j);
                    dis[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dis[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(end);
        visited[end.x][end.y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                dq.add(new Node(nx, ny));
                dis[nx][ny] = dis[now.x][now.y] + 1;
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