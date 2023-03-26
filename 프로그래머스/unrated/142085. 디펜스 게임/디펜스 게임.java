import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int n, int k, int[] enemy) {
        // PriorityQueue = 기본이 min heap (작은 숫자부터 꺼내짐)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int cnt = 0; // 라운드 수

        for (int e : enemy) {
            // 무적권 사용하는  경우
            // 남은 병사보다 적군 수가 더 많은 경우
            if (k > 0 && n < e) {
                pq.add(e); // 큐에 넣기
                n += pq.poll(); // 가장 큰 수는 빼서 무적권 사용하기 (회복)
                n -= e; // 들어온 숫자 병사에서 빼기
                k--; // 무적권 -1
                cnt++;
            }

            // 무적권 없는 경우
            else {
                // 남아있는 병사가 더 많은 경우
                if (n >= e) {
                    pq.add(e);
                    n -= e;
                    cnt++;
                }

                // 남아있는 병사가 더 적은 경우
                else {
                    break;
                }
            }
        }
        return cnt;
    }
}