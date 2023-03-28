public class Solution {
    static final int MAX = 1_000_000_000;
    static int N;
    static int[] time;

    public long solution(int n, int[] times) {
        long answer = 0;

        N = n;
        time = times;

        // 걸리는 시간의 범위
        long low = 1;
        long high = (long) MAX * MAX;

        while (low <= high) {
            long mid = (low + high) / 2;

            // mid 시간 안에 n명의 사람 심사 받을 수 있는 지 확인
            if (check(mid)) {
                high = mid - 1;
                answer = mid;
            } 
            else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private static boolean check(long mid) {
        long cnt = 0;

        for (int i : time) {
            cnt += (mid / i);
        }

        return cnt >= N;
    }
}