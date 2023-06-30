import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Node> virus = new ArrayList<>();

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0) {
                    virus.add(new Node(i, j));
                }
            }
        }

        int S = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        for (int i = 0; i < S; i++) {
            bfs();
        }
        System.out.println(map[X][Y]);
    }

    private static void bfs() {
        virus.sort(((o1, o2) -> Integer.compare(map[o1.x][o1.y], map[o2.x][o2.y])));

        ArrayDeque<Node> dq = new ArrayDeque<>();
        while (!virus.isEmpty()) {
            dq.add(virus.remove(0));
        }

        int size = dq.size();
        for (int i = 0; i < size; i++) {
            Node now = dq.poll();

            for (int j = 0; j < 4; j++) {
                int nx = now.x + dx[j];
                int ny = now.y + dy[j];

                if (nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1) {
                    continue;
                }

                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = map[now.x][now.y];
                    virus.add(new Node(nx, ny));
                }
            }
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}