import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];

        dfs(1, 0);
    }

    private static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (i < at) {
                continue;
            }
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}