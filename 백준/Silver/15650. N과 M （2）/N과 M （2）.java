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

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!check[i]) { // 방문하지 않았다면
                if (depth == 0) {
                    check[i] = true;
                    arr[depth] = i;
                    dfs(depth + 1);

                    check[i] = false;
                }

                else {
                    if (arr[depth - 1] < i) {
                        check[i] = true;
                        arr[depth] = i;
                        dfs(depth + 1);

                        check[i] = false;
                    }
                }
            }
        }
    }
}