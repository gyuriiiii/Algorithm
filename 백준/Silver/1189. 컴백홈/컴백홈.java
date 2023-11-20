import java.util.Scanner;

public class Main {
    static int r, c, k;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited[r - 1][0] = true;
        dfs(r - 1, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int cnt) {
        if (x == 0 && y == c - 1 && cnt == k) {
            answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }

            if (map[nx][ny] == 'T') {
                continue;
            }

            if (cnt + 1 > k) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, cnt + 1);
            visited[nx][ny] = false;
        }
    }
}