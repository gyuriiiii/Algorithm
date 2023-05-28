import java.util.Arrays;

class Solution {
     public int solution(int[] citations) {
        int result = 0;

        Arrays.sort(citations);
        int num = citations[citations.length - 1];

        for (int i = num; i >= 0; i--) {
            int down = 0;
            int up = 0;

            for (int j = 0; j < citations.length; j++) {
                if (citations[j] <= i) {
                    down++;
                }

                if (citations[j] >= i) {
                    up++;

                }
            }

            if (down <= i && up >= i) {
                result = i;
                break;
            }
        }
        return result;
    }
}