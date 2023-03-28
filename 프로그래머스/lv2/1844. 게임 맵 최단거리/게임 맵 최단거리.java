import java.util.ArrayDeque;

public class Solution {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] result = new int[n][m];
        
        visited[0][0] = true;
        result[0][0] = 1;
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] { 0, 0 });

        while (!dq.isEmpty()) {
            int[] current = dq.poll();
            int curx = current[0];
            int cury = current[1];

            for (int i = 0; i < 4; i++) {
                int nextx = curx + dx[i];
                int nexty = cury + dy[i];

                // map 벗어난 경우
                if (nextx < 0 || nexty < 0 || nextx >= n || nexty >= m) {
                    continue;
                }

                // 이미 방문한 경우
                if (visited[nextx][nexty]) {
                    continue;
                }

                // 벽인 경우
                if (maps[nextx][nexty] == 0) {
                    continue;
                }

                else {
                    visited[nextx][nexty] = true; // 방문 표시
                    dq.add(new int[] { nextx, nexty });
                    result[nextx][nexty] = result[curx][cury] + 1;
                }
            }
        }
        return result[n-1][m-1] == 0 ? -1 : result[n-1][m-1];
    }
}