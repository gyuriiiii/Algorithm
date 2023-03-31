import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int N;
    static int L;
    static int R;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 나라의 개수
        L = sc.nextInt();
        R = sc.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int day = 0;

        while (true) {
            flag = false; // 인구 이동 여부
            visited = new boolean[N][N]; // 방문여부 표시 배열

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            if(!flag) { // 인구 이동 없는 경우 종료
                break;
            }
            else {
                day++;
            }
        }
        System.out.println(day);
    }

    private static void bfs(int x, int y) {
        int sum = 0;

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        ArrayDeque<int[]> union = new ArrayDeque<>();

        visited[x][y] = true;
        dq.add(new int[]{x, y});
        union.add(new int[]{x, y}); // 연합국가에 추가
        sum += map[x][y]; // 연합국가의 합에 추가

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int curx = cur[0];
            int cury = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextx = curx + dx[i];
                int nexty = cury + dy[i];

                // map 벗어남
                if (nextx < 0 || nexty < 0 || nextx >= N || nexty >= N) {
                    continue;
                }

                if (visited[nextx][nexty]) {
                    continue;
                }

                int minus = Math.abs(map[curx][cury] - map[nextx][nexty]);
                if (minus >= L && minus <= R) {
                    flag = true;
                    visited[nextx][nexty] = true;
                    dq.add(new int[]{nextx, nexty});
                    union.add(new int[]{nextx, nexty}); // 연합국가에 추가
                    sum += map[nextx][nexty]; // 연합국가의 합에 추가
                }
            }
        }

        int avg = sum / union.size();
        while (!union.isEmpty()) {
            map[union.peekFirst()[0]][union.peekFirst()[1]] = avg;
            union.pollFirst();
        }
    }
}