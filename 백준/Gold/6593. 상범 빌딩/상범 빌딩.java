import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int L, R, C;
    static char[][][] map;
    static int[][][] cnt;
    static boolean[][][] visited;

    static Node start;
    static Node exit;

    static int[] dx = new int[]{-1, 1, 0, 0, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            map = new char[L][R][C];
            cnt = new int[L][R][C];
            visited = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = sc.next();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = s.charAt(k);

                        if (map[i][j][k] == 'S') { // 시작 위치
                            start = new Node(i, j, k);
                        }
                        if (map[i][j][k] == 'E') { // 출구 위치
                            exit = new Node(i, j, k);
                        }
                    }
                }
            }
            bfs(start);

            if (cnt[exit.floor][exit.x][exit.y] == 0) {
                System.out.println("Trapped!");
            }
            else {
                System.out.printf("Escaped in %d minute(s).\n", cnt[exit.floor][exit.x][exit.y]);
            }
        }
    }

    private static void bfs(Node start) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(start.floor, start.x, start.y));
        visited[start.floor][start.x][start.y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now == exit) {
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nz = now.floor + dz[i];
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= L || nx >= R || ny >= C) {
                    continue;
                }

                if (map[nz][nx][ny] == '#') {
                    continue;
                }

                if (!visited[nz][nx][ny]) {
                    visited[nz][nx][ny] = true;
                    dq.add(new Node(nz, nx, ny));
                    cnt[nz][nx][ny] = cnt[now.floor][now.x][now.y] + 1;
                }
            }
        }
    }

    static public class Node {
        int floor;
        int x;
        int y;

        public Node(int floor, int x, int y) {
            this.floor = floor;
            this.x = x;
            this.y = y;
        }
    }
}
