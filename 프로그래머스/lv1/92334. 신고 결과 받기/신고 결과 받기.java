import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, ArrayList> map = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            int idx = report[i].indexOf(" ");

            if (map.containsKey(report[i].substring(idx + 1, report[i].length()))) { 
                ArrayList<String> list = map.get(report[i].substring(idx + 1, report[i].length()));
                if (list.contains(report[i].substring(0, idx))) {
                    continue;
                }
                list.add(report[i].substring(0, idx));
                map.put(report[i].substring(idx + 1, report[i].length()), list);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(report[i].substring(0, idx));
                map.put(report[i].substring(idx + 1, report[i].length()), list);
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