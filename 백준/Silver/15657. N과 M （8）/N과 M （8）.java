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
        print = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        dfs(0, 0);
    }

    private static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(print[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i < N; i++) {
            int num = arr[i];

            print[depth] = num;
            dfs(i, depth + 1);
        }
    }
}