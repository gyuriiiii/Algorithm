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

            int cnt = -1; // 전력망 개수
            int[] nums = new int[2];

            for (int j = 1; j < n + 1; j++) {
                if (!visited[j]) {
                    cnt++;
                    if (cnt > 1) break;

                    num = 0;
                    nums[cnt] = dfs(j);
                }
            }

            connect[wires[i][0]][wires[i][1]] = true;
            connect[wires[i][1]][wires[i][0]] = true;

            answer = Math.min(answer, Math.abs(nums[0] - nums[1]));
        }
        return answer;
    }

    private static int dfs(int idx) {
        visited[idx] = true;
        num++;

        for (int next : list[idx]) {
            if (!visited[next]) {
                if (connect[idx][next]) {
                    dfs(next);
                }
            }
        }

        return num;
    }
}