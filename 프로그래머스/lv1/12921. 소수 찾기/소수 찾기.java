class Solution {
    public static int solution(int n) {
        int answer = 0;

        int arr[] = new int[n + 1];

        // 2, 3, 5, 7의 배수 차례로 지워주기
        for (int i = 2; i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                if (j <= n) {
                    arr[j] = -1;
                }
            }
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != -1) {
                answer++;
            }
        }

        return answer;
    }
}