import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> answer = new ArrayList<>();

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static public ArrayList<Integer> solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }

        if (answer.isEmpty()) answer.add(-1);
        Collections.sort(answer);
        return answer;
    }

    private static int bfs(int x, int y) {
        int sum = 0;

        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y));
        visited[x][y] = true;
        sum += map[x][y] - '0';

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 'X') {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny));
                    sum += map[nx][ny] - '0';
                }
            }
        }

        return sum;
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