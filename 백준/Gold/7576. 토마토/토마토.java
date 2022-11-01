import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M;
    static int N;
    static int[][] arr;
    static Queue<int[]> queue = new LinkedList<>(); // 큐

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();

                if (arr[i][j] == 1) { // 익은 토마토
                    queue.add(new int[] { i, j });
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()) { // 큐 빌 때 까지
            int[] q = queue.poll(); // 큐 가장 앞에 위치

            int x = q[0];
            int y = q[1];

            for (int i = 0; i < 4; i++) { // 위 아래 오른쪽 위 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[x][y] + 1; // day + 1
                    queue.add(new int[] { nx, ny });
                }
            }
        }

        if (checkZero()) {
            return -1;
        } 
        else {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                    }
                }
            }
            return max-1;
        }
    }

    private static boolean checkZero() {
        // 전부 안 익었으면 -1 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}