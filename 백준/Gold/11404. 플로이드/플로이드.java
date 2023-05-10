import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도시의 개수
        int m = sc.nextInt(); // 버스의 개수

        int[][] route = new int[n + 1][n + 1];
        int[][] cost = new int[n + 1][n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    cost[i][j] = 0;
                }
                else {
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            route[a][b] = 1;
            cost[a][b] = Math.min(cost[a][b], c);
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (route[i][k] == 1 && route[k][j] == 1) {
                        route[i][j] = 1;
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (route[i][j] == 0) {
                    System.out.print(0 + " ");
                }
                else {
                    System.out.print(cost[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}