import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 1][N + 1];

        // 초깃값 세팅
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = INF;

                // 자기 자신과의 거리는 0
                if (i == j)
                    arr[i][j] = 0;
            }
        }

        // 친구 관계 설정
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = arr[b][a] = 1;
        }

        // 최단 경로
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        // 케빈 베이컨의 수 가장 작은 사람 구하기
        int[] sum = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                sum[i] += arr[i][j];
            }
        }

        int min = sum[N - 1];
        int minIdx = N - 1;
        for (int i = N - 1; i >= 1; i--) {
            if (sum[i] <= min) {
                min = sum[i];
                minIdx = i;
            }
        }
        System.out.println(minIdx);
    }
}