import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    static int answer;
    static String[][] relations;
    static int tuple;
    static boolean visited[];
    static ArrayList<String> answers = new ArrayList<>();

    static public int solution(String[][] relation) {
        relations = relation;
        tuple = relation[0].length;

        visited = new boolean[tuple];

        for (int i = 1; i <= tuple; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            dfs(0, 0, i, list);
        }
        return answer;
    }

    public static void dfs(int start, int num, int cnt, ArrayList<Integer> list) {
        if (num == cnt) {
            String tmp = "";
            for (int l : list) {
                tmp += l;
            }

            if (check(list) && minimality(tmp)) {
                answers.add(tmp);
                answer++;
            }
            return;
        }

        for (int i = start; i < tuple; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                dfs(i + 1, num + 1, cnt, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
    
    private static boolean minimality(String tmp) {
        for (int i = 0; i < answers.size(); i++) {
            String answer = answers.get(i);
            boolean[] visit = new boolean[answer.length()];

            for (int j = 0; j < answer.length(); j++) {
                if (tmp.contains(answer.charAt(j) + "")) {
                    visit[j] = true;
                }
            }

            boolean flag = true;
            for (int j = 0; j < visit.length; j++) {
                if(!visit[j]) {
                    flag = false;
                }
            }

            if(flag) {
                return false;
            }
        }
        return true;
    }

    private static boolean check(ArrayList<Integer> list) {
        HashSet<String> set = new HashSet<>();

        for (String[] relation : relations) {
            String s = "";
            for (int i = 0; i < list.size(); i++) {
                s += relation[list.get(i)];
            }

            if (set.contains(s)) {
                return false;
            }
            set.add(s);
        }

        return true;
    }
}