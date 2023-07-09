import java.util.ArrayList;

public class Solution {
    static ArrayList<Integer>[] list;
    static int num;
    static boolean[] visited;
    static boolean[][] connect;

    static public int solution(int n, int[][] wires) {
        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        connect = new boolean[n + 1][n + 1];

        for (int i = 0; i < wires.length; i++) {
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);

            connect[wires[i][0]][wires[i][1]] = true;
            connect[wires[i][1]][wires[i][0]] = true;
        }

        int answer = Integer.MAX_VALUE; // 두 전력망의 송전탑 개수 차이

        for (int i = 0; i < wires.length; i++) {
            connect[wires[i][0]][wires[i][1]] = false;
            connect[wires[i][1]][wires[i][0]] = false;

            visited = new boolean[n + 1];
            visited[1] = true;

            dfs(1);

            int cnt = 0;
            for (int j = 1; j < visited.length; j++) {
                if (visited[j]) cnt++;
            }

            connect[wires[i][0]][wires[i][1]] = true;
            connect[wires[i][1]][wires[i][0]] = true;

            answer = Math.min(answer, Math.abs(n - (2 * cnt)));
        }

        System.out.println(answer);
        return answer;
    }

    private static void dfs(int idx) {
        for (int next : list[idx]) {
            if (!visited[next] && connect[idx][next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}