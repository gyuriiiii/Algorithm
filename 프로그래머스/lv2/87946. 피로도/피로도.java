class Solution {
    static int len;
    static boolean[] visited;
    static int[] order;
    static int K;
    static int[][] dungeon;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        K = k;
        dungeon = dungeons;

        len = dungeons.length;
        visited = new boolean[len];
        order = new int[len];

        backtracking(0);
        return answer;
    }
    
    void backtracking(int cnt) {
        if (cnt == len) {
            answer = Math.max(answer, adventure());
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[cnt] = i;
                backtracking(cnt + 1);
                visited[i] = false;
            }
        }
    }

    static int adventure() {
        int power = K;
        int cnt = 0;

        for (int i = 0; i < order.length; i++) {
            if (power < dungeon[order[i]][0]) {
                break;
            }
            power -= dungeon[order[i]][1];
            cnt++;
        }
        return cnt;
    }
}