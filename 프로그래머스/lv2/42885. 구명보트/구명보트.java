import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;

        Arrays.sort(people); // 오름차순 정렬

        int min = 0;
        for (int i = people.length - 1; min <= i; i--) {
            if (people[i] + people[min] <= limit) { // 사람 더 구조할 수 있는 경우
                min++;
            }
            cnt++;
        }
        return cnt;
    }
}