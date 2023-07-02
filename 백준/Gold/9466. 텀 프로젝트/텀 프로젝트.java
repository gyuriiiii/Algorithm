import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int cnt;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());

                if (j == arr[j]) {
                    cnt++;
                    finished[j] = true;
                }
            }

            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }

            System.out.println(n - cnt);
        }
    }

    private static void dfs(int now) {
        if (visited[now]) {
            finished[now] = true;
            cnt++;
        }
        else {
            visited[now] = true;
        }

        if (!finished[arr[now]]) {
            dfs(arr[now]);
        }

        visited[now] = false; 
        finished[now] = true; 
    }
}