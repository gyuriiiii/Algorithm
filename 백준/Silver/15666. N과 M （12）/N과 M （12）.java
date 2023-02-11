import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;

    static int[] arr;
    static int[] print;

    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static StringBuilder sb2 = new StringBuilder();

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
        System.out.println(sb2);
    }

    private static void dfs(int at, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(print[i]).append(" ");
            }

            if (!set.contains(sb.toString())) {
                sb2.append(sb.toString()).append("\n");
                set.add(sb.toString());
            }

            return;
        }

        for (int i = at; i < N; i++) {
            print[depth] = arr[i];

            dfs(i, depth + 1);
        }
    }
}