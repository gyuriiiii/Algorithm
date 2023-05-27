import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scovile, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scovile.length; i++) {
            queue.add(scovile[i]);
        }

        if (check(K, queue)) {
            return 0;
        }

        while (!queue.isEmpty()) {
            if (check(K, queue) || queue.size() < 2) {
                break;
            }

            int num1 = queue.poll();
            int num2 = queue.poll();
            int sum = num1 + (num2 * 2);

            queue.add(sum);
            answer++;
        }

        if (!check(K, queue)) {
            answer = -1;
        }
        return answer;
    }

    private static boolean check(int k, PriorityQueue<Integer> queue) {
        for (Integer q : queue) {
            if (q < k) {
                return false;
            }
        }
        return true;
    }
}