import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String[][] clothes) {
        HashSet<String> set = new HashSet<>(); // 의상 종류
        HashMap<String, Integer> map = new HashMap<>(); // 의상 종류 - 의상 개수

        for (int i = 0; i < clothes.length; i++) {
            set.add(clothes[i][1]);
            if (map.containsKey(clothes[i][1])) {
                int cnt = map.get(clothes[i][1]);
                map.put(clothes[i][1], cnt + 1);
            }
            else {
                map.put(clothes[i][1], 1);
            }
        }

        int cnt = 1;
        for (Integer value : map.values()) {
            cnt *= (value + 1);
        }

        return cnt - 1;
    }
}