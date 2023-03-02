public class Solution {
    static public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int cnt = 0;

            if (i == 1) {
                cnt = 1;
            }

            else {
                for (int j = 1; j * j <= i; j++) {
                    if (j * j == i) {
                        cnt++;
                    }
                    else if (i % j == 0) {
                        cnt += 2; // 쌍으로 더해주기
                    } 
                }
            }

            if (cnt <= limit) {
                answer += cnt;
            } 
            else {
                answer += power;
            }
        }
        return answer;
    }
}