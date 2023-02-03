class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);

            char tmp = word;
            int idx = 0;

            while (idx < index) {
                tmp = tmp == 'z' ? 'a' : (char) (tmp + 1);

                if (!skip.contains(tmp + "")) {
                    idx++;
                }
            }
            answer += tmp;
        }

        return answer;
    }
}