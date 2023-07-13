import java.util.Scanner;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] dis = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i != j) dis[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            dis[a][b] = Math.min(dis[a][b], c);
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (dis[i][j] == INF) {
                    dis[i][j] = 0;
                }
                sb.append(dis[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}