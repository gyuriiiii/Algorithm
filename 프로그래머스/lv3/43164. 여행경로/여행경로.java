import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    static String[][] ticket;
    static boolean[] visited;
    static ArrayList<String> answer;

    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();

        ticket = tickets;
        visited = new boolean[tickets.length]; // 방문 여부 배열

        // 출발지 기준으로 정렬 (출발지가 같다면, 도착지 기준으로 정렬)
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                if (s1[0].compareTo(s2[0]) > 0) return 1;
                else if (s1[0].compareTo(s2[0]) == 0) return s1[1].compareTo(s2[1]);
                else return -1;
            }
        });

        dfs(0, "ICN", "ICN");
        Collections.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        return answer.get(0).split(" ");
    }

    private static void dfs(int cnt, String now, String path) {
        // 모든 도시 방문한 경우
        if (cnt == ticket.length) {
            answer.add(path);
            return;
        }

        for (int j = 0; j < ticket.length; j++) {
            if (visited[j]) continue;

            // 경로 있는 경우
            if (ticket[j][0].equals(now)) {
                visited[j] = true;
                dfs(cnt + 1, ticket[j][1], path + " " + ticket[j][1]);
                visited[j] = false;
            }
        }
    }
}