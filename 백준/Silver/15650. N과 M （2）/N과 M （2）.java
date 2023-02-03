import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        check = new boolean[N + 1];

        dfs(1, 0);
    }

    // at 부터만 탐색
    private static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++) {
            if (!check[i]) { // 방문하지 않았다면
                check[i] = true;
                arr[depth] = i;
                dfs(i + 1, depth + 1);

                check[i] = false;
            }
        }
    }
}