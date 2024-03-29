import java.util.LinkedList;
import java.util.Queue;

class Solution {
     boolean solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                queue.add(c);
            }
            if(c == ')') {
                if(queue.isEmpty()) {
                    return false;
                }
                queue.poll();
            }
        }

        if(!queue.isEmpty()) return false;

        return true;
    }
}