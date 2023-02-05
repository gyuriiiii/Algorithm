import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
        public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = 0;

            if ((100 - progresses[i]) % speeds[i] == 0) {
                day = (100 - progresses[i]) / speeds[i];
            } 
            else {
                day = (100 - progresses[i]) / speeds[i] + 1;
            }

            deque.offerLast(day);
        }

        while (!deque.isEmpty()) {
            int cnt = 0;

            int complete = deque.pollFirst();

            while (true) {
                if (deque.size() == 0 || complete < deque.peekFirst()) {
                    break;
                }
                deque.pollFirst();
                cnt++;
            }
            list.add(cnt + 1);
        }
        return list;
    }
}