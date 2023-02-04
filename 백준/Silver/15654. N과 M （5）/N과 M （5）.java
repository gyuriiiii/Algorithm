import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;

    static int[] arr;
    static boolean[] check;
    static int[] print;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        check = new boolean[10001];
        print = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(print[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            int num = arr[i];

            if (!check[num]) { // 방문한 적 없으면
                check[num] = true;
                print[depth] = num;
                dfs(depth + 1);
                check[num] = false;
            }
        }
    }
}