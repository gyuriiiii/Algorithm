public class Solution {
    static int[] answer;

    static public int[] solution(int[][] arr) {
        answer = new int[2];
        
        int n = arr.length;
        press(0, 0, n, arr);
        
        return answer;
    }

    private static void press(int startX, int startY, int size, int[][] arr) {
        if (check(startX, startY, size, arr)) {
            answer[arr[startX][startY]]++;
            return;
        }

        press(startX, startY, size / 2, arr);
        press(startX, startY + size / 2, size / 2, arr);
        press(startX + size / 2, startY, size / 2, arr);
        press(startX + size / 2, startY + size / 2, size / 2, arr);
    }

    private static boolean check(int startX, int startY, int size, int[][] arr) {
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (arr[startX][startY] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}