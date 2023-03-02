import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, int[]> list = new HashMap<>();

        list.put(1, new int[] { 1, 2, 3, 4, 5 });
        list.put(2, new int[] { 2, 1, 2, 3, 2, 4, 2, 5 });
        list.put(3, new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 });

        int[] result = new int[3];
        result[0] = check(answers, list.get(1));
        result[1] = check(answers, list.get(2));
        result[2] = check(answers, list.get(3));

        int max = Integer.MIN_VALUE;
        for (int i : result) {
            if (i > max) {
                max = i;
            }
        }

        for (int j = 0; j < result.length; j++) {
            if (result[j] == max) {
                answer.add(j + 1);
            }
        }
        return answer;
    }

    private static int check(int[] answers, int[] list) {
        int cnt = 0;

        for (int i = 0; i < answers.length; i++) {
            int idx = i;

            if (idx >= list.length) {
                idx = i % list.length;
            }

            if (answers[i] == list[idx]) {
                cnt++;
            }
        }

        return cnt;
    }
}