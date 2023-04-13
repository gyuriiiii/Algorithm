import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static Node start;
    static Node end;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static ArrayDeque<Node> waters = new ArrayDeque<>();
    static int[][] cnt;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        cnt = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S') { // 고슴도치 위치
                    start = new Node(i, j);
                }
                else if (map[i][j] == 'D') { // 비버의 굴 위치
                    end = new Node(i, j);
                }
                else if (map[i][j] == '*') { // 물의 위치
                    waters.add(new Node(i, j));
                }
            }
        }

        bfs(start);
        if (cnt[end.x][end.y] == 0) {
            System.out.println("KAKTUS");
        }
        else {
            System.out.println(cnt[end.x][end.y]);
        }
    }

    private static void bfs(Node location) {
        ArrayDeque<Node> dq = new ArrayDeque<>();

        visited[location.x][location.y] = true;
        dq.add(new Node(location.x, location.y));

        while (!dq.isEmpty()) {
            // 물 채우기
            int w_size = waters.size();
            for (int i = 0; i < w_size; i++) {
                Node water = waters.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = water.x + dx[j];
                    int ny = water.y + dy[j];

                    // map 벗어난 경우
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                        continue;
                    }

                    // 비어있는 칸으로만 확장 가능
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        waters.add(new Node(nx, ny));
                    }
                }
            }

            // 고슴도치 이동 시키기
            int d_size = dq.size();
            for (int i = 0; i < d_size; i++) {
                Node now = dq.poll();

                if(map[now.x][now.y] == 'D') {
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    // map 벗어난 경우, 이미 방문한 경우
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) {
                        continue;
                    }

                    // 물이 차있거나, 돌이 있는 경우
                    if (map[nx][ny] == '*' || map[nx][ny] == 'X') {
                        continue;
                    }

                    visited[nx][ny] = true;
                    cnt[nx][ny] = cnt[now.x][now.y] + 1;
                    dq.add(new Node(nx, ny));
                }
            }
        }
    }
}