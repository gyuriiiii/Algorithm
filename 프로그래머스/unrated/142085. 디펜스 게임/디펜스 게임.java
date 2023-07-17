import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    static public int solution(int n, int k, int[] enemy) {
        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 

        for (int i = 0; i < enemy.length; i++) {
            // 무적권 사용하는 경우
            if (k > 0 && n < enemy[i]) {
                pq.add(enemy[i]);
                n += pq.poll(); // 회복
                n -= enemy[i];
                k--;
                result++;
            }

            // 무적권 사용하지 않는 경우
            else {
                // 남은 병사가 더 많은 경우
                if (n >= enemy[i]) {
                    n -= enemy[i];
                    pq.add(enemy[i]);
                    result++;
                } 
                // 적수가 더 많은 경우 => 종료
                else {
                    break;
                }
            }
        }
        return result;
    }
}