import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static boolean flag;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        while (true) {
            flag = false;

            // 터질 뿌요 있는 지 탐색
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && map[i][j] != ' ') {
                        visited = new boolean[12][6];
                        checkPuyo(i, j);
                    }
                }
            }

            // 터질 뿌요가 없는 경우
            if (!flag) {
                break;
            }
            cnt++; // +1 연쇄

            // 위에 있는 뿌요들 아래로 이동
            for (int i = 11; i > 0; i--) {
                for (int j = 0; j < 6; j++) {
                    int idx = i - 1;

                    if (map[i][j] == ' ') {
                        while (true) {
                            if(idx <= 0) {
                                break;
                            }

                            if (map[idx][j] != ' ') {
                                break;
                            }
                            idx--;
                        }

                        map[i][j] = map[idx][j];
                        map[idx][j] = ' ';
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    private static void checkPuyo(int x, int y) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        ArrayDeque<int[]> pos = new ArrayDeque<>();

        pos.add(new int[]{x, y});
        dq.add(new int[]{x, y});
        visited[x][y] = true;

        while (!dq.isEmpty()) {
            int[] now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                if (visited[nx][ny]) continue;

                if (map[now[0]][now[1]] == map[nx][ny]) {
                    dq.add(new int[]{nx, ny});
                    visited[nx][ny] = true;

                    pos.add(new int[]{nx, ny});
                }
            }
        }

        // 같은 색 뿌요 4개 이상인 경우 => 터뜨리기
        if (pos.size() >= 4) {
            flag = true;
            while (!pos.isEmpty()) {
                int[] p = pos.poll();

                map[p[0]][p[1]] = ' ';
            }
        }
    }
}