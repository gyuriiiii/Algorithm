import java.util.Arrays;

public class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        
        int boxNum = score.length / m;

        int[][] box = new int[boxNum][m];
        int idx = score.length - 1;

        // 각 상자에 사과 포장
        for (int i = 0; i < boxNum; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = score[idx--];
            }
        }

        // 각 상자의 가격 구하기
        int sum = 0;
        for (int i = 0; i < boxNum; i++) {
            Arrays.sort(box[i]);

            sum += (box[i][0] * m);
        }
        return sum;
    }
}