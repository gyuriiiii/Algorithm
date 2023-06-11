import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        makeSet(str1, list1);
        makeSet(str2, list2);

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        makeMap(list1, map1);
        makeMap(list2, map2);

        int intersection = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
            }
        }

        HashMap<String, Integer> unionMap = new HashMap<>(map1);
        for (String key : map2.keySet()) {
            if (unionMap.containsKey(key)) {
                unionMap.put(key, Math.max(unionMap.get(key), map2.get(key)));
            }
            else {
                unionMap.put(key, map2.get(key));
            }
        }

        int union = 0;
        for (String s : unionMap.keySet()) {
            union += unionMap.get(s);
        }
        
        if(intersection == 0 && union == 0) {
            return 65536;
        }

        double similarity = (intersection * 1.0) / (union * 1.0);
        similarity *= 65536;

        int answer = (int) similarity;
        return answer;
    }

    private static void makeMap(ArrayList<String> list, HashMap<String, Integer> map) {
        for (String s : list) {
            if (map.containsKey(s)) {
                int cnt = map.get(s);
                map.put(s, cnt + 1);
            }
            else {
                map.put(s, 1);
            }
        }
    }

    private static void makeSet(String str, ArrayList<String> list) {
        for (int i = 0; i < str.length(); i++) {
            String s = "";
            for (int j = i; j < i + 2; j++) {
                if (j > str.length() - 1) {
                    break;
                }

                if (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z') {
                    s += str.charAt(j);
                }
            }
            if (s.length() == 2) {
                list.add(s);
            }
        }
    }
}