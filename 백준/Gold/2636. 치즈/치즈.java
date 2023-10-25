import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] map;
    static int answer;
    static int cheeseNum, totalTime;
    static ArrayList<Node> meltList = new ArrayList<>();
    static boolean[][] visited, melt;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1) {
                    cheeseNum++;
                }
            }
        }

        melt = new boolean[n][m];

        while (true) {
            if (cheeseNum == 0) {
                break;
            }

            visited = new boolean[n][m];
            bfs();
            answer = cheeseNum;
            cheeseNum -= meltList.size();
            melting();
            totalTime++;
        }

        System.out.println(totalTime);
        System.out.println(answer);
    }

    private static void melting() {
        for (Node m : meltList) {
            map[m.x][m.y] = 0;
        }
        meltList.clear();
    }

    private static void bfs() {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, 0));
        visited[0][0] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    if (!melt[nx][ny]) {
                        melt[nx][ny] = true;
                        meltList.add(new Node(nx, ny));
                    }
                }

                else if (map[nx][ny] == 0) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dq.add(new Node(nx, ny));
                    }
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