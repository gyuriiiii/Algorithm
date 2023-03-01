public class Solution {
    public String solution(int a, int b) {
        int[] month = new int[] { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] day = new String[] { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };

        int result = 0; // 일수

        if (a == 1) {
            result += (b-1);
            return (day[result % 7]);
        }

        else {
            result += (month[1] - 1);
            for (int i = 2; i < a; i++) {
                result += month[i];
            }
            result += b;
        }
        return (day[result % 7]);
    }
}