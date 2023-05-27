class Solution {static boolean[] visited;
    static int answer;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        backtracking(0, k, dungeons);
        return answer;
    }

    private void backtracking(int cnt, int power, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > power) {
                continue;
            }

            visited[i] = true;
            backtracking(cnt + 1, power - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        answer = Math.max(answer, cnt);
    }
}