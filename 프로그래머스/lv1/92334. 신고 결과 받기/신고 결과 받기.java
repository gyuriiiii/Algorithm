import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, ArrayList> map = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String reporter = report[i].split(" ")[0];
            String reportered = report[i].split(" ")[1];

            if (map.containsKey(reportered)) { // 이미 존재하는 경우
                ArrayList<String> list = map.get(reportered);
                if (list.contains(reporter)) {
                    continue;
                }
                list.add(reporter);
                map.put(reportered, list);
            } 
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(reporter);
                map.put(reportered, list);
            }
        }

        HashMap<String, Integer> result = new HashMap<>();
        for (String name : map.keySet()) {
            if (map.get(name).size() >= k) {
                ArrayList<String> list = map.get(name);
                for (int i = 0; i < list.size(); i++) {
                    result.put(list.get(i), result.getOrDefault(list.get(i), 0) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            if (!result.containsKey(id_list[i])) {
                answer[i] = 0;
            } 
            else {
                answer[i] = result.get(id_list[i]);
            }
        }
        return answer;
    }
}