import java.util.ArrayDeque;

public class Solution {
    static char[][] map;
    static int[] dx = new int[]{0, 1, 1};
    static int[] dy = new int[]{1, 0, 1};

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        map = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            ArrayDeque<int[]> removeSet = new ArrayDeque<>();
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == ' ')
                        continue;

                    boolean flag = true;
                    for (int k = 0; k < 3; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                            flag = false;
                            break;
                        }

                        if (map[nx][ny] != map[i][j]) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        if (!visited[i][j]) {
                            removeSet.add(new int[]{i, j});
                        }
                        for (int k = 0; k < 3; k++) {
                            if (!visited[i + dx[k]][j + dy[k]]) {
                                visited[i + dx[k]][j + dy[k]] = true;
                                removeSet.add(new int[]{i + dx[k], j + dy[k]});
                            }
                        }
                    }
                }
            }

            if (removeSet.isEmpty()) {
                break;
            }

            answer += removeSet.size();
            for (int[] rem : removeSet) {
                map[rem[0]][rem[1]] = ' ';
            }
            moveCharacters(m, n);
        }

        return answer;
    }

    private static void moveCharacters(int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] != ' ') continue;
                if (i - 1 < 0) continue;

                for (int k = i - 1; k >= 0; k--) {
                    if (map[k][j] != ' ') {
                        map[i][j] = map[k][j];
                        map[k][j] = ' ';
                        break;
                    }
                }
            }
        }
    }
}