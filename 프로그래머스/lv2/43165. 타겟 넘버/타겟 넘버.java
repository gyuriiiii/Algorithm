public class Solution {
    static int num;
    static int[] number, arr;
    static int Target;
    static int answer;

    static public int solution(int[] numbers, int target) {
        number = numbers;
        Target = target;

        arr = new int[number.length];

        backtracking(0, numbers.length);
        return answer;
    }

    private static void backtracking(int cnt, int num) {
        if (cnt == num) {
            if (calculate()) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            arr[cnt] = i;
            backtracking(cnt + 1, num);
        }
    }

    private static boolean calculate() {
        int result = 0;

        for (int i = 0; i < number.length; i++) {
            if (arr[i] == 0) {
                result += number[i];
            }
            else {
                result -= number[i];
            }
        }

        return result == Target;
    }
}