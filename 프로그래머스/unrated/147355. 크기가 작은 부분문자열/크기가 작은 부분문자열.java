class Solution {
    public static int solution(String t, String p) {
        int answer = 0;

        int len = p.length(); // p의 길이

        for (int i = 0; i < t.length() - len + 1; i++) {
            String word = "";
            int idx = i;

            for (int j = 0; j < len; j++) {
                char s = t.charAt(idx);
                word += s;
                idx++;
            }
            if (Long.parseLong(word) <= Long.parseLong(p)) {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}