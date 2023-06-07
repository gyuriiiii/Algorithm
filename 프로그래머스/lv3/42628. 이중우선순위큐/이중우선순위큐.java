import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String op = operation.split(" ")[0];
            int num = Integer.parseInt(operation.split(" ")[1]);

            if (op.equals("I")) {
                minQ.add(num);
                maxQ.add(num);
            }
            else if (op.equals("D")) {
                if (!minQ.isEmpty()) {
                    if (num == 1) {
                        int tmp = maxQ.poll();
                        minQ.remove(tmp);
                    }
                    else if (num == -1) {
                        int tmp = minQ.poll();
                        maxQ.remove(tmp);
                    }
                }
            }
        }

        int[] answer = new int[2];

        if (minQ.isEmpty() && maxQ.isEmpty()) {
            answer[0] = answer[1] = 0;
        }
        else {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        return answer;
    }
}