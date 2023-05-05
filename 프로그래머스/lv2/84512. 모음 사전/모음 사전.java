import java.util.ArrayList;

public class Solution {
    static String[] arr;
    static ArrayList<String> list;

    public int solution(String word) {
        int answer = 0;

        arr = new String[]{"A", "E", "I", "O", "U"};
        list = new ArrayList<>();

        dfs(word, "", 0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    private static void dfs(String word, String s, int depth) {
        list.add(s);

        if (depth == 5) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            dfs(word, s + arr[i], depth + 1);
        }
    }
}