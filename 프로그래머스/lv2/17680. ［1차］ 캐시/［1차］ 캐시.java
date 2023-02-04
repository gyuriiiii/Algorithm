import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    static public int solution(int cacheSize, String[] cities) {
        int time = 0;

        ArrayDeque<String> cache = new ArrayDeque<>();

        for (int i = 0; i < cities.length; i++) { 
            String city = cities[i].toLowerCase(); 

            // hit !!
            if (cache.contains(city)) { 
                cache.remove(city);
                
                // 가장 앞으로
                cache.offerFirst(city);
                time += 1;
            }

            // miss
            else {
                cache.offerFirst(city);
                
                // 캐시 가득 찬 경우
                if (cache.size() > cacheSize) {
                    cache.pollLast(); // 가장 오래된 데이터 제거
                }
                time += 5;
            }
        }
        System.out.println(time);
        return time;
    }
}