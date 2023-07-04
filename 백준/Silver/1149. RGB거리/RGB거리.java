import java.util.Scanner;

public class Main {
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        dp = new int[N][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(calculateCost(N - 1, 0), Math.min(calculateCost(N - 1, 1), calculateCost(N - 1, 2))));
    }

    static int calculateCost(int i, int color) {
        if (dp[i][color] == 0) {
            if (color == 0) {
                dp[i][0] = Math.min(calculateCost(i - 1, 1), calculateCost(i - 1, 2)) + cost[i][0];
            }
            else if (color == 1) {
                dp[i][1] = Math.min(calculateCost(i - 1, 0), calculateCost(i - 1, 2)) + cost[i][1];
            }
            else {
                dp[i][2] = Math.min(calculateCost(i - 1, 0), calculateCost(i - 1, 1)) + cost[i][2];
            }
        }

        return dp[i][color];
    }
}