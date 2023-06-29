import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr, order;
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        order = new int[N];
        visited = new boolean[N];

        dfs(0, N);
        System.out.println(answer);
    }

    private static void dfs(int cnt, int n) {
        if (cnt == n) {
            calculate();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[cnt] = i;
                dfs(cnt + 1, n);
                visited[i] = false;
            }
        }
    }

    private static void calculate() {
        int sum = 0;

        for (int i = 1; i < N; i++) {
            sum += Math.abs(arr[order[i-1]] - arr[order[i]]);
        }

        answer = Math.max(answer, sum);
    }
}