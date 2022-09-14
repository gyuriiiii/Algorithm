class Solution {
    public String solution(String phone_number) {        
        String answer = "";
        
        for(int i=0; i<phone_number.length(); i++) {
            if(i < phone_number.length()-4) { // 4자리수 전까지
                answer += "*"; // *로 변경
            }
            else { // 그 외
                answer += phone_number.charAt(i);
            }
        }
        
        return answer;
    }
}