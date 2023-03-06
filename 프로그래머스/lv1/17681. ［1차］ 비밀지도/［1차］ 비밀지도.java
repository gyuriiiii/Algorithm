class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = "";
        }

        for (int i = 0; i < n; i++) {
            // 10진수 -> 2진수 변환
            String s1 = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            String s2 = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr2[i])));


            for (int j = 0; j < n; j++) {
                if (s1.charAt(j) == '0' && s2.charAt(j) == '0') { // 공백
                    answer[i] += " ";
                } 
                else {
                    answer[i] += "#";
                }
            }
        }
        return answer;
    }
}