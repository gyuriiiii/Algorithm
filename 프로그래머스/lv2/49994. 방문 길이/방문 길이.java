public class Solution {
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static boolean[][][][] visited;

    static public int solution(String dirs) {
        int answer = 0;

        visited = new boolean[11][11][11][11];

        int nowx = 5;
        int nowy = 5;

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);

            int step = 0;
            if (c == 'U') {
                step = 0;
            }
            else if (c == 'D') {
                step = 1;
            }
            else if (c == 'L') {
                step = 2;
            }
            else if (c == 'R') {
                step = 3;
            }

            int nx = nowx + dx[step];
            int ny = nowy + dy[step];

            if (nx < 0 || ny < 0 || nx > 10 || ny > 10) {
                continue;
            }

            if (!visited[nowx][nowy][nx][ny]) {
                visited[nowx][nowy][nx][ny] = true;
                visited[nx][ny][nowx][nowy] = true;
                answer++;
            }
            nowx = nx;
            nowy = ny;
        }
        return answer;
    }
}