import java.util.ArrayList;
import java.util.HashMap;

class Solution {
            public static ArrayList<Integer> solution(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, i); // 위치 저장

                list.add(i, -1);
            }

            else {
                int idx = i - map.get(c);
                map.put(c, i);

                list.add(i, idx);
            }
        }
        System.out.println(list);
        return list;
    }
}