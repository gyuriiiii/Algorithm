import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    static HashMap<String, Integer> word = new HashMap<>();

    static public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();

        int n = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            word.put(i + "", n++);
        }

        for (int i = 0; i < msg.length(); i++) {
            String w = msg.charAt(i) + "";
            int idx = i + 1; // 다음 글자 (c) 얻기 위한 index

            while (idx <= msg.length()) {
                if (idx == msg.length()) {
                    answer.add(word.get(msg.substring(i)));
                    i = idx;
                    break;
                }

                String tmp = msg.substring(i, idx + 1);

                // 사전에 존재하는 경우
                if (word.containsKey(tmp)) {
                    idx++;
                }
                // 사전에 존재하지 않는 경우
                else {
                    String s = msg.substring(i, idx);
                    answer.add(word.get(s));
                    word.put(tmp, word.size() + 1);
                    i = idx - 1;
                    break;
                }
            }
        }

        return answer;
    }
}