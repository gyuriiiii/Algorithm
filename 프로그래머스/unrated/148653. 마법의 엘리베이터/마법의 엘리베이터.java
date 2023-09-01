class Solution {
    public int solution(int storey) {
        int answer = 0;

        String s = Integer.toString(storey);
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            int n = arr[i];

            if (n < 5) {
                answer += n;
            }
            else if (n > 5) {
                answer += (10 - n);
                if(i == 0) answer ++;
                else arr[i-1]++;
            }
            else {
                if (i > 0) {
                    if (arr[i - 1] < 5) {
                        answer += n;
                    }
                    else {
                        answer += 5;
                        arr[i - 1]++;
                    }
                }
                else {
                    answer += 5;
                }
            }
        }
        return answer;
    }
}