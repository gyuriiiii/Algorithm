import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static int solution(String s) {
        Deque<Character> dq = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!dq.isEmpty()) {
                if (c == dq.peekLast()) {
                    dq.pollLast();
                } 
                else {
                    dq.offer(c);
                }
            } 
            else {
                dq.offer(c);
            }
        }

        if(dq.isEmpty()) return 1;
        else return 0;
    }
}