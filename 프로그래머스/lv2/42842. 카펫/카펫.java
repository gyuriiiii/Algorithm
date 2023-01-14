class Solution {
   static public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int num = brown + yellow;

        for (int i = 1; i <= num; i++) {
            int j = num / i;

            if (num % j == 0 && j >= 3) {
                int n1 = Math.max(i, j);
                int n2 = Math.min(i, j);
                int comp = (n1 - 2) * (n2 - 2);

                if (yellow == comp) {
                    answer[0] = n1;
                    answer[1] = n2;
                }
            }
        }

        return answer;
    }
}