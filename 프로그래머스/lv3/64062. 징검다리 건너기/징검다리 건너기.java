public class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int low = 0;
        int high = 200000000;

        while (low <= high) {
            int mid = (low + high) / 2; // 징검다리 건널 인원

            if (check(mid, stones, k)) { // mid명 건널 수 있음
                low = mid + 1;
                answer = mid;
            } 
            else { // mid명 건널 수 없음
                high = mid - 1;
            }
        }
        return answer;
    }

    // mid명의 인원이 징검다리 건널 수 있는 지 확인
    private static boolean check(int mid, int[] stones, int k) {
        int cnt = 0; // 연속적으로 건널 수 없는 징검다리

        for (int stone : stones) {
            if (stone < mid) {
                cnt++;
            } 
            else {
                cnt = 0; 
            }
            
            if (cnt == k) {
                return false;
            }
        }

        return true; 
    }
}