import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        visited = new boolean[N + 1];

        dfs(0, N, "");
        System.out.println(sb);
    }

    private static void dfs(int cnt, int n, String s) {
        if (cnt == n) {
            for (int i = 0; i < n; i++) {
                sb.append(s.charAt(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cnt + 1, n, s += i);
                s = s.substring(0, s.length() - 1);
                visited[i] = false;
            }
        }
    }
}