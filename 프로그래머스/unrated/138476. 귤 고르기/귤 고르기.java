import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            if (map.containsKey(tangerine[i])) {
                int cnt = map.get(tangerine[i]);
                map.put(tangerine[i], cnt + 1);
            }
            else {
                map.put(tangerine[i], 1);
            }
        }

        ArrayList<Integer> cnt = new ArrayList<>(map.keySet());
        Collections.sort(cnt, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(map.get(o2), map.get(o1));
            }
        });

        int idx = 0;
        while (k > 0) {
            k -= map.get(cnt.get(idx++));
            answer++;
        }

        return answer;
    }
}