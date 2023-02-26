import java.util.HashMap;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        HashMap<Character, Integer> map = new HashMap<>(); // 각 알파벳 자판 몇번 눌러야하는 지
        for (int i = 0; i < keymap.length; i++) {
            String s = keymap[i];

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (map.containsKey(c)) {
                    if (map.get(c) >= j + 1) {
                        map.put(c, j + 1);
                    }
                }

                else {
                    map.put(c, j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String s = targets[i];

            for (int j = 0; j < s.length(); j++) {
                if (!map.containsKey(s.charAt(j))) {
                    answer[i] = -1;
                    break;
                }
                answer[i] = answer[i] + map.get(s.charAt(j));
            }
        }
        return answer;
    }
}
