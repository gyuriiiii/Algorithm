class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length() == 0) return answer;
        
        s = s.toLowerCase();
        answer += Character.toUpperCase(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer += " ";
            }
            else if(s.charAt(i-1) == ' ') {
                answer += Character.toUpperCase(s.charAt(i));
            }
            else {
                answer += s.charAt(i);
            }
        }
        return answer;
    }
}