import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public static int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = new int[rc.length][rc[0].length];

        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<Integer> right = new ArrayDeque<>();
        ArrayDeque<ArrayDeque<Integer>> mid = new ArrayDeque<>();

        // first, mid, right 각 큐에 배열 값 넣기
        for (int i = 0; i < rc.length; i++) {
            left.offer(rc[i][0]);

            ArrayDeque<Integer> midQueue = new ArrayDeque<>();
            for (int j = 1; j < rc[i].length - 1; j++) {
                midQueue.add(rc[i][j]);
            }
            mid.offer(midQueue);

            right.offer(rc[i][rc[i].length - 1]);
        }

        for (String operation : operations) {
            if (operation.equals("ShiftRow")) {
                left.offerFirst(left.pollLast());
                mid.offerFirst(mid.pollLast());
                right.offerFirst(right.pollLast());
            }

            else {
                mid.peekFirst().offerFirst(left.pollFirst());
                right.offerFirst(mid.peekFirst().pollLast());
                mid.peekLast().offerLast(right.pollLast());
                left.offerLast(mid.peekLast().pollFirst());
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = left.poll();

            ArrayDeque<Integer> x = mid.pollFirst();
            for (int j = 1; j < rc[i].length - 1; j++) {
                answer[i][j] = x.poll();
            }

            answer[i][answer[i].length - 1] = right.poll();
        }
        return answer;
    }
}