import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int cnt;

    static boolean[] visited;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점 개수
        M = sc.nextInt(); // 간선 개수
        
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        cnt = 0;

        // 간선의 양 끝점
        for(int i=0; i<M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            arr[n1][n2] = 1;
            arr[n2][n1] = 1;
        }

        for(int i=1; i<visited.length; i++) {
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int n) {
        visited[n] = true; // 방문 여부 표시

        for(int i=1; i<=N; i++) {
            if(arr[n][i] == 1 && !visited[i])  {
                dfs(i);
            }
        }
    }
}