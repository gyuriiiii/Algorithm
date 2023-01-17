import java.util.Scanner;

public class Main {
    static int N;
    static int M;

    static int[] arr;
    static boolean[] check; // 방문 여부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        check = new boolean[N];
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) { // 방문 X
                check[i] = true;
                arr[depth] = i + 1;
                dfs(depth+1);

                check[i] = false;
            }
        }
    }
}