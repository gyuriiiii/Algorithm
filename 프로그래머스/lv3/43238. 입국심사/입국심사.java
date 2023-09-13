class Solution {
    static final int MAX = 1_000_000_000;

    static public long solution(int n, int[] times) {
        long answer = 0;

        long start = 1;
        long end = (long) MAX * MAX;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int t : times) {
                sum += mid / t; 
            }

            if (sum < n) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}