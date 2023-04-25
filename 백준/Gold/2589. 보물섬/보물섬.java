import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static ArrayList<Node> lands = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'L') lands.add(new Node(i, j));
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < lands.size(); i++) {
            Node land = lands.get(i);

            boolean[][] visit = new boolean[N][M];
            int[][] cnt = new int[N][M];
            bfs(land, visit, cnt);

            int max = cnt[0][0];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    max = Math.max(max, cnt[j][k]);
                }
            }
            answer = Math.max(answer, max);
        }
        System.out.println(answer);
    }

    private static void bfs(Node land, boolean[][] visit, int[][] cnt) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(land.x, land.y));
        visit[land.x][land.y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // map 벗어난 경우
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (!visit[nx][ny] && map[nx][ny] == 'L') {
                    visit[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                    cnt[nx][ny] = cnt[now.x][now.y] + 1;
                }
            }
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