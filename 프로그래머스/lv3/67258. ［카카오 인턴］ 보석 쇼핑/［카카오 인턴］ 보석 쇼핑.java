import java.util.HashMap;

public class Solution {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String gem : gems) {
            map.put(gem, 0);
        }

        int max = map.size(); 

        int left = 0;
        int right = 0;

        int start = 1; 
        int end = gems.length; 

        int min = gems.length; 

        map = new HashMap<>();
        while (right < gems.length) {
            if (map.containsKey(gems[right])) {
                int cnt = map.get(gems[right]);
                map.put(gems[right], cnt + 1);
            }
            else {
                map.put(gems[right], 1);
            }
            right++;

            while (map.size() == max) {
                if (right - left < min) {
                    min = right - left;
                    start = left + 1;
                    end = right;
                }

                int cnt = map.get(gems[left]) - 1;
                if (cnt == 0) {
                    map.remove(gems[left]);
                }
                else {
                    map.put(gems[left], cnt);
                }
                left++;
            }
        }
        return new int[]{start, end};
    }
}