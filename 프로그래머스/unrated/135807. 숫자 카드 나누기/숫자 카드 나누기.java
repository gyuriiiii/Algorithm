import java.util.Arrays;

class Solution {
    static int answer;

    static public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        checkNum(arrayA, arrayB);
        checkNum(arrayB, arrayA);

        return answer;
    }

    private static void checkNum(int[] arr1, int[] arr2) {
        for (int i = 2; i <= arr1[arr1.length - 1]; i++) {
            boolean flag1 = true;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] % i != 0) {
                    flag1 = false;
                    break;
                }
            }

            boolean flag2 = true;
            if (flag1) {
                for (int j = 0; j < arr2.length; j++) {
                    if (arr2[j] % i == 0) {
                        flag2 = false;
                        break;
                    }
                }

                if (flag2) {
                    answer = Math.max(answer, i);
                }
            }
        }
    }
}