import java.util.HashMap;

public class Solution {
    static HashMap<Long, Long> parent = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }

        return answer;
    }

    static private long find(long a) {
        if (!parent.containsKey(a)) {
            parent.put(a, a + 1);
            return a;
        }
        parent.put(a, find(parent.get(a)));
        return parent.get(a);
    }
}