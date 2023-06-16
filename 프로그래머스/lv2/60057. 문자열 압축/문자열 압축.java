
public class Solution {
    public int solution(String s) {
        if(s.length() == 1) return 1;
        
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < s.length(); i++) {
            answer = Math.min(answer, compress(s, i));
        }
        
        return answer;
    }

    private static int compress(String s, int idx) {
        String word = "";

        String prev = "";
        String now = "";

        int cnt = 1;
        for (int i = 0; i <= s.length() - idx; i += idx) {
            now = s.substring(i, i + idx);

            if (prev.equals("")) {
                prev = now;
                continue;
            }

            if (now.equals(prev)) {
                cnt++;
            }
            else {
                if (cnt == 1) {
                    word += prev;
                }
                else {
                    word += (cnt + "" + prev);
                }
                prev = s.substring(i, i + idx);
                cnt = 1;
            }
        }

        if (cnt == 1) {
            word += prev;
        }
        else {
            word += (cnt + "" + prev);
        }

        int remain = s.length() % idx;
        word += s.substring(s.length() - remain, s.length());

        return word.length();
    }
}