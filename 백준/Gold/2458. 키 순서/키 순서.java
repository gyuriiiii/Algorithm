import java.util.Scanner;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        int result = 0;

        for (int i = 1; i < N + 1; i++) {
            boolean flag = true;
            for (int j = 1; j < N + 1; j++) {
                if (arr[i][j] == INF && arr[j][i] == INF) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result++;
            }
        }
        System.out.println(result);
    }
}