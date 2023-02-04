class Solution {
    public int solution(int[] number) {
        int cnt = 0;

        for (int i = 0; i < number.length; i++) {
            int num1 = number[i];
            for (int j = i + 1; j < number.length; j++) {
                int num2 = number[j];
                for (int k = j + 1; k < number.length; k++) {
                    int num3 = number[k];

                    int sum = num1 + num2 + num3;
                    if(sum == 0) cnt++;
                }
            }
        }

        return cnt;
    }
}