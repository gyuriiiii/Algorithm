import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    static HashMap<Character, Character> map = new HashMap<>();
    
        public int solution(String s) {
        int answer = 0;

        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        String newS = s;
        for (int i = 0; i < s.length(); i++) {
            if (check(newS)) {
                answer++;
            }
            
            newS = newS.substring(1, s.length()) + newS.charAt(0);
        }

        System.out.println(answer);
        return answer;
    }

    // 올바른 괄호인 지 검사
    private static boolean check(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                deque.offerLast(c);
            }

            if (deque.isEmpty()) {
                return false;
            }

            if (c == map.get(deque.peekLast())) {
                deque.pollLast();
            }
        }
        return deque.isEmpty();
    }
}