import java.util.Arrays;

class Solution {
       static public int solution(int n, int[] lost, int[] reserve) {
        int cnt = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    cnt++;
                    reserve[j] = -1; // 여분 있었지만 도난 당한 학생
                    lost[i] = -1;
                    break;
                }
            }
        }

        for (int j = 0; j < lost.length; j++) {
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == lost[j] - 1 || reserve[i] == lost[j] + 1) {
                    cnt++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        return cnt;
    }
}