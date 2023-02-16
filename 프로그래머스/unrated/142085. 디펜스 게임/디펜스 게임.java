import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int n, int k, int[] enemy) {
        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap

        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            // 무적권 사용하는 경우
            // 무적권 남아있고 병사 수보다 적군 수가 많은 경우
            if(k > 0 && n < e) {
                k--;
                pq.add(e);
                n = n + pq.poll() - e;
                result++;
            } 

            // 무적권 사용하지 않는 경우
            else {
                // 무적권은 없지만
                // 병사 수가 적군 수보다 많은 경우
                if(n >= e) {
                    n -= e;
                    pq.add(e);
                    result++;
                }

                // 병사 수도 적군 수보다 적고
                // 무적권도 없는 경우
                else {
                    break;
                }
            }
        }
        return result;
    }
}