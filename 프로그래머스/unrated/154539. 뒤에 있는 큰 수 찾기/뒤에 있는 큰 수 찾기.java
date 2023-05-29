import java.util.ArrayDeque;

class Solution {
      public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!dq.isEmpty()) {
                if (dq.peekLast() > numbers[i]) {
                    answer[i] = dq.peekLast();
                    break;
                }
                else {
                    dq.pollLast();
                }
            }

            if (dq.size() == 0) {
                answer[i] = -1;
            }
            dq.addLast(numbers[i]);
        }

        return answer;
    }
}