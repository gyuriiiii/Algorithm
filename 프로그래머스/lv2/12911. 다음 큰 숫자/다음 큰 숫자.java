class Solution {
    public static int solution(int n) {
        int answer = 0;
        String changeN = Integer.toString(n, 2);

        int cnt1 = 0;
        for (int i = 0; i < changeN.length(); i++) {
            if (changeN.charAt(i) == '1') {
                cnt1++;
            }
        }

        for (int i = n + 1; i <= 1000000; i++) {
            int cnt2 = 0;
            String changeI = Integer.toString(i, 2);

            for (int j = 0; j < changeI.length(); j++) {
                if (changeI.charAt(j) == '1') {
                    cnt2++;
                }
            }

            if (cnt1 == cnt2) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}