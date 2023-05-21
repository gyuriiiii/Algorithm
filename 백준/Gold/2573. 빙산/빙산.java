import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;
    static int result = 1;

    static ArrayDeque<Node> dq = new ArrayDeque<>();

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] > 0) {
                    dq.add(new Node(i, j));
                }
            }
        }

        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        while (!dq.isEmpty()) {
            int size = dq.size();

            int[][] minus = new int[N][M];
            for (int i = 0; i < size; i++) {
                Node now = dq.poll();

                int cnt = 0;
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }

                    if (map[nx][ny] == 0) {
                        cnt++;
                    }
                }

                minus[now.x][now.y] = cnt;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (minus[i][j] > 0) {
                        map[i][j] -= minus[i][j];

                        if (map[i][j] < 0) {
                            map[i][j] = 0;
                        }
                    }

                    if (map[i][j] > 0) {
                        dq.add(new Node(i, j));
                    }
                }
            }

            // 빙산이 분리된 경우 => 종료
            if (!checkSeperate()) {
                return;
            }
            result++;
        }
    }

    private static boolean checkSeperate() {
        ArrayDeque<Node> tmpDq = new ArrayDeque<>();
        Node check = null;

        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
                if (tmp[i][j] > 0) {
                    check = new Node(i, j);
                }
            }
        }

        if(check == null) {
            result = 0;
            return false;
        }

        tmpDq.add(check);

        while (!tmpDq.isEmpty()) {
            Node now = tmpDq.poll();
            tmp[now.x][now.y] = 0;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (tmp[nx][ny] > 0) {
                    tmp[nx][ny] = 0;
                    tmpDq.add(new Node(nx, ny));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
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