import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[] used;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        used = new boolean['Z' - 'A' + 1]; // 알파벳 사용 여부 배열
        used[map[0][0] - 'A'] = true; // 첫 번째 말 빙문 표시

        backtracking(0, 0, 1);
        System.out.println(answer);
    }

    private static void backtracking(int x, int y, int cnt) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // map 벗어남
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }

            // 알파벳 중복
            if (used[map[nx][ny] - 'A']) {
                continue;
            }

            used[map[nx][ny] - 'A'] = true;
            backtracking(nx, ny, cnt + 1);
            used[map[nx][ny] - 'A'] = false;
        }
    }
}