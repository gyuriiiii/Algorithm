import java.util.ArrayList;

public class Solution {
    static String[] word;
    static int answer;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;

        word = words;
        visited = new boolean[word.length];

        ArrayList<String> list = new ArrayList<>();
        for(String s : word) {
            list.add(s);
        }

        if(!list.contains(target)) {
            return 0;
        }

        dfs(begin, target, 0);
        return answer;
    }

    private static void dfs(String begin, String target, int cnt) {
        if (begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = 0; i < word.length; i++) {
            if (visited[i]) {
                continue;
            }

            // 한 글자만 차이나는지 검사 (word[i]와 begin)
            int different = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (word[i].charAt(j) != begin.charAt(j)) {
                    different++;
                }
            }

            if (different == 1) {
                visited[i] = true;
                dfs(word[i], target, cnt + 1);
                visited[i] = false;
            }
        }
    }
}