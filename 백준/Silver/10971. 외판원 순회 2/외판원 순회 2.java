import java.util.Scanner;

public class Main {
    static int N;
    static int[][] W;
    static boolean[] visited;

    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 도시의 수

        W = new int[N][N];

        // 각 도시간 이동하는데 드는 비용
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                W[i][j] = sc.nextInt();
            }
        }

        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            visited = new boolean[N]; // 도시 방문 여부 배열

            if (!visited[i]) { // 아직 방문 안 한 도시
                visited[i] = true;
                backtrack(i, i, 1, 0);
            }
        }
        System.out.println(min);
    }

    private static void backtrack(int start, int city, int cnt, int money) {
        visited[start] = true;

        if (cnt == N) {
            if (W[city][start] != 0) {
                money += W[city][start];
                min = Math.min(min, money);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[city][i] != 0) {
                visited[i] = true;
                money += W[city][i];
                backtrack(start, i, cnt + 1, money);

                visited[i] = false;
                money -= W[city][i];
            }
        }
    }
}