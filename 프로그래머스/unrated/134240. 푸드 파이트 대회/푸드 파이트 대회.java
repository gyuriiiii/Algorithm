class Solution {
  public static String solution(int[] food) {
        String answer = "";

        int len = food.length;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer += i;
            }
        }
        answer += 0;

        for(int i=answer.length()-2; i>=0; i--) {
            answer += answer.charAt(i);
        }

        System.out.println(answer);
        return answer;
    }
}