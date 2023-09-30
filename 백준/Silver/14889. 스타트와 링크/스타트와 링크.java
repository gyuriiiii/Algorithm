import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] power;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        power = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N / 2);
        System.out.println(result);
    }

    private static void dfs(int idx, int cnt, int num) {
        if (cnt == num) {
            calculate();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1, num);
                visited[i] = false;
            }
        }
    }

    private static void calculate() {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 0; i < visited.length - 1; i++) {
            for (int j = i + 1; j < visited.length; j++) {
                if (visited[i] && visited[j]) {
                    startScore += power[i][j];
                    startScore += power[j][i];
                }
                else if (!visited[i] && !visited[j]) {
                    linkScore += power[i][j];
                    linkScore += power[j][i];
                }
            }
        }
        result = Math.min(result, Math.abs(startScore - linkScore));
    }
}