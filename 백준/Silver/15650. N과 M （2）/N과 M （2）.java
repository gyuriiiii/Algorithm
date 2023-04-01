import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[] used;
    static int[] arr;

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        used = new boolean[N + 1];
        arr = new int[M];
        sb = new StringBuilder();

        backtracking(0, 0);
        System.out.println(sb);
    }

    private static void backtracking(int num, int depth) {
        if (depth == M) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = num + 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                arr[depth] = i;
                backtracking(i, depth + 1);
                used[i] = false;
            }
        }
    }
}