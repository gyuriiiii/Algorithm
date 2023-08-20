import java.util.Arrays;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean[] painted = new boolean[n + 1];
        Arrays.fill(painted, true);

        for (int i = 0; i < section.length; i++) {
            painted[section[i]] = false;
        }

        for (int i = 0; i < section.length; i++) {
            if (!painted[section[i]]) {
                answer++;

                for (int j = section[i]; j < section[i] + m; j++) {
                    if (j > n) {
                        break;
                    }
                    else {
                        painted[j] = true;
                    }
                }
            }
        }

        return answer;
    }
}