import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int[] len1 = new int[sizes.length];
        int[] len2 = new int[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            len1[i] = sizes[i][0];
            len2[i] = sizes[i][1];
        }

        int[] result1 = new int[sizes.length];
        int[] result2 = new int[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            result1[i] = Math.min(len1[i], len2[i]);
            result2[i] = Math.max(len1[i], len2[i]);
        }
        Arrays.sort(result1);
        Arrays.sort(result2);

        answer = result1[result1.length - 1] * result2[result2.length - 1];

        return answer;
    }
}