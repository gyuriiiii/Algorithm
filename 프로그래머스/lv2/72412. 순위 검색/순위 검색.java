import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    static public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String s : info) {
            String[] arr = s.split(" ");
            dfs(arr, "", 0);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");

            if (map.containsKey(q[0])) {
                answer[i] = binarySearch(q[0], Integer.parseInt(q[1]));
            }
        }

        return answer;
    }

    private static int binarySearch(String key, int score) {
        ArrayList<Integer> list = map.get(key);

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (list.get(mid) < score) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return list.size() - low;
    }

    private static void dfs(String[] arr, String s, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(s)) {
                ArrayList<Integer> list = new ArrayList<>();
                map.put(s, list);
            }
            map.get(s).add(Integer.parseInt(arr[4]));

            return;
        }
        dfs(arr, s + "-", cnt + 1);
        dfs(arr, s + arr[cnt], cnt + 1);
    }
}