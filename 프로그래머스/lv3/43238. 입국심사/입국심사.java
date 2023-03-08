public class Solution {
    static final int MAX = 1_000_000_000;
    static int[] time;
    static int N;

    static public long solution(int n, int[] times) {
        N = n;
        time = times;

        long start = 1;
        long end = (long) MAX * MAX;
        
        while (start < end) { 
            long mid = (start + end) / 2;

            if (isPossible(mid)) {
                end = mid;
            } 
            else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean isPossible(long mid) {
        long n = N;

        for (int t : time) { 
            n -= mid / t;
        }

        return n <= 0;
    }
}