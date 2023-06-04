import java.util.Scanner;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도시 개수
        int m = sc.nextInt(); // 버스 개수

        int[][] dis = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                dis[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); // 시작 도시
            int b = sc.nextInt(); // 도착 도시
            int c = sc.nextInt(); // 비용

            dis[a][b] = Math.min(dis[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dis[i][j] == INF) {
                    dis[i][j] = 0;
                }
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }
    }
}