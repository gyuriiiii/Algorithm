class Solution {
    static char next;
    
    static public String solution(String s, String skip, int index) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);

            int idx = 0;
            int j = 0;

            while (idx != index) {
                next = (char) ((int) word + ++j);
                if(next == '{') {
                    next = 'a';
                    word = 'a';
                    j = 0;
                }

                if (skip.contains(next + "")) {
                    continue;
                }
                idx++;
            }

            answer += next;
        }

        return answer;
    }
}