import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (answer % arr[i] == 0) {
                continue;
            }
            else if (arr[i] % answer == 0) {
                answer = arr[i];
            }
            else {
                for (int j = answer; j <= answer * arr[i]; j++) {
                    if (j % answer == 0 && j % arr[i] == 0) {
                        answer = j;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}