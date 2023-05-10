import java.util.Scanner;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] dis = new int[V + 1][V + 1];
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                dis[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            dis[a][b] = c;
        }

        for (int k = 1; k < V + 1; k++) {
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i != j && dis[i][j] != INF && dis[j][i] != INF) {
                    result = Math.min(result, dis[i][j] + dis[j][i]);
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println("-1");
        }
        else {
            System.out.println(result);
        }
    }
}