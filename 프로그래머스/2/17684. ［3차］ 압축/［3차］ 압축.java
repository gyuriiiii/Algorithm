import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    static HashMap<String, Integer> word = new HashMap<>();

    static public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (char i = 'A'; i <= 'Z'; i++) {
            word.put(i + "", 26 - ('Z' - i));
        }

        int idx = 0;
        while (idx < msg.length()) {
            String w = msg.charAt(idx) + "";
            String tmp = find(idx, msg);

            if (word.containsKey(tmp)) {
                answer.add(word.get(tmp));
            }

            if (idx + tmp.length() >= msg.length()) {
                break;
            }

            String c = msg.charAt(idx + tmp.length()) + "";
            
            if (!word.containsKey(tmp + "" + c)) {
                word.put(tmp + "" + c, word.size() + 1);
            }

            idx += tmp.length();
        }

        return answer;
    }

    private static String find(int idx, String msg) {
        String s = "";
        String maxS = "";

        for (int i = idx; i < msg.length(); i++) {
            s += msg.charAt(i);

            if (word.containsKey(s)) {
                maxS = s;
            }
            else {
                break;
            }
        }
        return maxS;
    }
}