class Solution {
    public int solution(int[][] sizes) {
        int height = 0;
        int length = 0;

        for (int[] size : sizes) {
            height = Math.max(height, Math.max(size[0], size[1]));
            length = Math.max(length, Math.min(size[0], size[1]));
        }

        int answer = height * length;
        return answer;
    }
}