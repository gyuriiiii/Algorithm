import java.util.Arrays;

public class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        Arrays.fill(answer, s / n);

        if (s % n != 0) {
            int remain = s % n;
            for (int i = n - remain; i < n; i++) {
                answer[i]++;
            }
        }
        return answer;
    }
}