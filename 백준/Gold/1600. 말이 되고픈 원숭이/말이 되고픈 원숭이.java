import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int K, H, W;
    static int[][] map;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[] hx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

    static int[][] result;
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt(); // 움직일 수 있는 횟수
        H = sc.nextInt(); // 세로길이
        W = sc.nextInt(); // 가로길이

        map = new int[W][H];
        result = new int[W][H];
        visited = new boolean[W][H][K + 1];

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited[0][0][K] = true;
        min = bfs(0,0);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(result[W - 1][H - 1]);
        }
    }

    public static class Node {
        int x;
        int y;
        int k;

        public Node(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    private static int bfs(int x, int y) {
        ArrayDeque<Node> dq = new ArrayDeque<>();

        dq.add(new Node(x, y, K));

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.x == W - 1 && now.y == H - 1) {
                return result[W - 1][H - 1];
            }

            // 원숭이 점프
            for (int j = 0; j < 4; j++) {
                int nx = now.x + dx[j];
                int ny = now.y + dy[j];

                // map 벗어난 경우
                if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
                    continue;
                }

                // 장애물 있거나
                if (map[nx][ny] == 1) {
                    continue;
                }

                // 방문하지 않은 경우
                if (!visited[nx][ny][now.k]) {
                    visited[nx][ny][now.k] = true;
                    dq.add(new Node(nx, ny, now.k));

                    result[nx][ny] = result[now.x][now.y] + 1;
                }
            }

            // 말 점프
            if (now.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = now.x + hx[i];
                    int ny = now.y + hy[i];

                    // map 벗어난 경우
                    if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
                        continue;
                    }

                    // 장애물 있거나
                    if (map[nx][ny] == 1) {
                        continue;
                    }

                    // 방문하지 않은 경우
                    if (!visited[nx][ny][now.k - 1]) {
                        visited[nx][ny][now.k - 1] = true;
                        dq.add(new Node(nx, ny, now.k - 1));

                        result[nx][ny] = result[now.x][now.y] + 1;
                    }
                }
            }
        }
        return min;
    }
}