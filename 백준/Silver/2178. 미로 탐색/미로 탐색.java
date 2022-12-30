import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int N;
    static int M;
    static boolean[][] check;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j });
        check[i][j] = true;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();

            int curX = cur[0];
            int curY = cur[1];

            for (int k = 0; k < 4; k++) {
                int nextX = curX + dx[k];
                int nextY = curY + dy[k];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                // 이동할 수 없거나 이미 방문한 칸
                if (arr[nextX][nextY] == 0 || check[nextX][nextY]) {
                    continue;
                }

                queue.add(new int[] { nextX, nextY });
                check[nextX][nextY] = true;
                arr[nextX][nextY] = arr[curX][curY] + 1;
            }
        }
    }
}