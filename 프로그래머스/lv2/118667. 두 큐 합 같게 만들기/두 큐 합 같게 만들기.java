import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        ArrayDeque<Integer> dq1 = new ArrayDeque<>();
        ArrayDeque<Integer> dq2 = new ArrayDeque<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            dq1.addLast(queue1[i]);
            dq2.addLast(queue2[i]);

            sum1 += queue1[i];
            sum2 += queue2[i];
        }


        while (sum1 != sum2) {
            if (answer > 4 * queue1.length) {
                return -1;
            }
            
            if (sum1 == sum2) {
                break;
            }
            else if (sum1 < sum2) {
                sum1 += dq2.peekFirst();
                sum2 -= dq2.peekFirst();
                dq1.addLast(dq2.pollFirst());
            }
            else {
                sum2 += dq1.peekFirst();
                sum1 -= dq1.peekFirst();
                dq2.addLast(dq1.pollFirst());
            }

            answer++;
        }
        return answer;
    }
}