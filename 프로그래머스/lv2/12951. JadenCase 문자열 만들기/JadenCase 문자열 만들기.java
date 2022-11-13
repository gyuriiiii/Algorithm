class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.toLowerCase().split("");

        boolean flag = true;

        for (String word : arr) {
            answer += flag ? word.toUpperCase() : word; // flag true면 대문자로
            flag = word.equals(" ") ? true : false; // " " 이면 다음 문자 대문자로 하기 위해
        }

        return answer;
    }
}