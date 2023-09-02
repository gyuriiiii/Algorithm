class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int len = number.length() - k;
        int start = 0;

        while (true) {
            if (start > number.length()) {
                break;
            }

            if (sb.length() == len) {
                break;
            }

            int end = k + sb.length() + 1;
            int max = 0;

            for (int i = start; i < end; i++) {
                if (max < number.charAt(i) - '0') {
                    max = number.charAt(i) - '0';
                    start = i + 1;
                }
            }
            sb.append(Integer.toString(max));
        }
        return sb.toString();
    }
}