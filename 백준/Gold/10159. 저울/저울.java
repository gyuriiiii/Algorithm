import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] weight = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            weight[a][b] = 1;
            weight[b][a] = -1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (weight[i][k] == 1 && weight[k][j] == 1) {
                        weight[i][j] = 1;
                    }
                    else if (weight[i][k] == -1 && weight[k][j] == -1) {
                        weight[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    if (weight[i][j] == 0) {
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}