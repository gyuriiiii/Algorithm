import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int[] arrB = new int[B.length];
        for (int i = B.length - 1; i >= 0; i--) {
            arrB[B.length-i-1] = B[i];
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (A[i] * arrB[i]);
        }
        System.out.println(sum);
        return sum;
    }
}