import java.util.ArrayDeque;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int[] order = new int[n + 1];

        ArrayDeque<String> dq = new ArrayDeque<>();

        for (int i = 0; i < words.length; i++) {
            int person = (i + 1) % n;
            if (person == 0) {
                person = n;
            }

            String word = words[i];

            if (!dq.isEmpty()) {
                if (dq.contains(word) || word.charAt(0) != dq.peekLast().charAt(dq.peekLast().length() - 1)) {
                    answer[0] = person;
                    answer[1] = order[person] + 1;

                    break;
                }
            }

            dq.add(word);
            order[person]++;
        }
        return answer;
    }
}