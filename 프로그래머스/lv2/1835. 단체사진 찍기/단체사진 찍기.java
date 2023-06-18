public class Solution {
    static String[] friends;
    static boolean[] visited;
    static String[] Data;
    static int answer;

    static public int solution(int n, String[] data) {
        friends = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
        Data = data;
        answer = 0;

        visited = new boolean[8];
        dfs(0, n, "");

        return answer;
    }

    private static void dfs(int cnt, int n, String s) {
        if (cnt == 8) {
            if (check(s)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cnt + 1, n, s += friends[i]);
                s = s.substring(0, s.length() - 1);
                visited[i] = false;
            }
        }
    }

    private static boolean check(String s) {
        for (String data : Data) {
            char start = data.charAt(0);
            char end = data.charAt(2);
            char type = data.charAt(3);
            int num = Integer.parseInt(data.charAt(4) + "");

            int minus = Math.abs(s.indexOf(start) - s.indexOf(end)) - 1;

            if (type == '=') {
                if (num != minus) {
                    return false;
                }
            }
            else if (type == '<') {
                if (num <= minus) {
                    return false;
                }
            }
            else if (type == '>') {
                if (num >= minus) {
                    return false;
                }
            }
        }
        return true;
    }
}