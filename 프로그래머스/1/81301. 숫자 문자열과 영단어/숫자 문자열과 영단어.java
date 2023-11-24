import java.util.HashMap;

public class Solution {
    static public int solution(String s) {
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> map = new HashMap<>();

        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(tmp.toString())) {
                sb.append(map.get(tmp.toString()));
                tmp = new StringBuilder();
            }

            if (Character.isDigit(c)) {
                sb.append(c);
            }
            else {
                tmp.append(c);
            }
        }

        if (!tmp.toString().equals("")) {
            sb.append(map.get(tmp.toString()));
        }
        
        int result = Integer.parseInt(sb.toString());
        return result;
    }
}