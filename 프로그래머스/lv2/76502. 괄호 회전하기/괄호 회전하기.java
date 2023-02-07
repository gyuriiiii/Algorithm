import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    static HashMap<Character, Character> map = new HashMap<>();
    
    static public int solution(String s) {
        int answer = 0;

        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            ArrayDeque<Character> originDeque = new ArrayDeque<>();
            for (int j = 0; j < s.length(); j++) {
                originDeque.offerLast(s.charAt(j));
            }
            
            for (int k = 0; k < i; k++) {
                originDeque.offerLast(originDeque.pollFirst());
            }
            
            if (check(originDeque)) {
                answer++;
            }
        }
        return answer;
    }

    // 올바른 괄호인 지 검사
    private static boolean check(ArrayDeque<Character> originDeque) {
        ArrayDeque<Character> deque = new ArrayDeque<>();

        int size = originDeque.size();
        for (int i = 0; i < size; i++) {
            char c = originDeque.pollFirst();

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