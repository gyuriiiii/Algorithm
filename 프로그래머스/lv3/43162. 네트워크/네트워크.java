public class Solution {
    static int N;
    static int[][] computer;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int cnt = 0; 

        N = n;
        computer = computers;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { 
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
        return cnt;
    }

    private static void dfs(int now) {
        if(visited[now]) {
           return; 
        }

        visited[now] = true;

        for (int i = 0; i < computer[now].length; i++) {
            if (computer[now][i] == 1) {
                dfs(i);
            }
        }
    }
}