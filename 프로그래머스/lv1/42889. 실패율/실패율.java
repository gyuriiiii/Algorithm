import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    
    public ArrayList<Integer> solution(int N, int[] stages) {
        HashMap<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int stage = i + 1;

            double total = 0; // 스테이지에 도달했지만 클리어하지 못한 플레이어
            double pass = 0; // 스테이지에 도달한 플레이어 수

            for (int j = 0; j < stages.length; j++) {
                if (stages[j] < stage) {
                    continue;
                }

                if (stages[j] > stage) {
                    pass++;
                }
                total++;
            }

            if (total == 0) {
                map.put(stage, 0.0);
            }
            else {
                map.put(stage, (total - pass) / total);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1) == map.get(o2)) {
                    return Integer.compare(o1, o2);
                }
                return Double.compare(map.get(o2), map.get(o1));
            }
        });

        return list;
    }
}