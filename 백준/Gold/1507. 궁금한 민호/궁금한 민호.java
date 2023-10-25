import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 도시 개수
        int[][] time = new int[N + 1][N + 1];

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                time[i][j] = sc.nextInt();
                if (i < j) {
                    sum += time[i][j];
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (time[i][j] > time[i][k] + time[k][j]) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        boolean[][] remove = new boolean[N + 1][N + 1];
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i < j && i != k && j != k && !remove[i][j]) {
                        if (time[i][j] == time[i][k] + time[k][j]) {
                            remove[i][j] = true;
                            sum -= time[i][j];
                        }
                    }
                }
            }
        }

        System.out.println(sum);
    }
}