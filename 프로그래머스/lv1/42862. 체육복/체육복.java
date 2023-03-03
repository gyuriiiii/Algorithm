import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int cnt = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복 가져온 학생이 도난 당한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    cnt++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]) { // 앞뒤 학생
                    lost[i] = -1;
                    reserve[j] = -1;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}