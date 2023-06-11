import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    static String[] order;
    static boolean[] visited;
    static char[] arr;
    static HashMap<String, Integer> map;

    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        order = orders;

        for (int i : course) {
            map = new HashMap<>();
            for (int j = 0; j < order.length; j++) {
                visited = new boolean[order[j].length()];
                arr = new char[i];
                dfs(0, 0, i, j);
            }

            if(map.isEmpty()) {
                continue;
            }

            ArrayList<String> list = new ArrayList<>(map.keySet());
            list.sort(((o1, o2) -> Integer.compare(map.get(o2), map.get(o1))));

            int max = map.get(list.get(0));
            if(max < 2) {
                break;
            }

            for (String key : list) {
                if (map.get(key) == max) {
                    answer.add(key);
                }
                else {
                    break;
                }
            }
        }

        answer.sort((o1, o2) -> o1.compareTo(o2));
        return answer;
    }

    private static void dfs(int start, int num, int depth, int idx) {
        if (num == depth) {
            char[] tmp = new char[arr.length];
            for (int i = 0; i < arr.length; i++) {
                tmp[i] = arr[i];
            }

            Arrays.sort(tmp);

            String s = "";
            for (char c : tmp) {
                s += c;
            }

            if (map.containsKey(s)) {
                int cnt = map.get(s);
                map.put(s, cnt + 1);
            }
            else {
                map.put(s, 1);
            }
            return;
        }

        for (int i = start; i < order[idx].length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[num] = order[idx].charAt(i);
                dfs(i, num + 1, depth, idx);
                arr[num] = ' ';
                visited[i] = false;
            }
        }
    }
}