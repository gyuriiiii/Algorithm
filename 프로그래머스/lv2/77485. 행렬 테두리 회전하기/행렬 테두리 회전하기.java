import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    static int[][] map;
    static int x1, y1, x2, y2;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        // 행렬 값 저장
        map = new int[rows + 1][columns + 1];
        int num = 1;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                map[i][j] = num++;
            }
        }

        // 회전 시킬 범위 (x1, y1) ~ (x2, y2)
        for (int i = 0; i < queries.length; i++) {
            x1 = queries[i][0];
            y1 = queries[i][1];
            x2 = queries[i][2];
            y2 = queries[i][3];

            // 행렬 회전
            answer[i] = rotate(map);
        }

        return answer;
    }

    // 행렬 테두리 회전
    // 회전 후 가장 작은 수 반환
    private static int rotate(int[][] map) {
        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<Integer> right = new ArrayDeque<>();
        ArrayDeque<ArrayDeque<Integer>> mid = new ArrayDeque<>();

        // left, right, mid 값 저장 & 가장 작은 수 구하기
        for (int i = x1; i <= x2; i++) {
            left.add(map[i][y1]);

            ArrayDeque<Integer> midQueue = new ArrayDeque<>();
            for (int j = y1 + 1; j <= y2 - 1; j++) {
                midQueue.add(map[i][j]);
            }
            mid.add(midQueue);

            right.add(map[i][y2]);
        }

        // 회전 작업
        mid.peekFirst().offerFirst(left.pollFirst());
        right.offerFirst(mid.peekFirst().pollLast());
        mid.peekLast().offerLast(right.pollLast());
        left.offerLast(mid.peekLast().pollFirst());

        // 최솟값 찾기
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < left.size(); i++) {
            list.add(left.peekFirst());
            left.offerLast(left.pollFirst());

            list.add(right.peekFirst());
            right.offerLast(right.pollFirst());
        }

        ArrayDeque<Integer> dequeFirst = mid.peekFirst();
        for (int i = 0; i < dequeFirst.size(); i++) {
            list.add(dequeFirst.peekFirst());
            dequeFirst.offerLast(dequeFirst.pollFirst());
        }

        ArrayDeque<Integer> dequeLast = mid.peekLast();
        for (int i = 0; i < dequeLast.size(); i++) {
            list.add(dequeLast.peekFirst());
            dequeLast.offerLast(dequeLast.pollFirst());
        }
        Collections.sort(list);

        // map 변경
        for (int i = x1; i <= x2; i++) {
            map[i][y1] = left.pollFirst();

            ArrayDeque<Integer> midQueue = mid.pollFirst();
            for (int j = y1 + 1; j <= y2 - 1; j++) {
                map[i][j] = midQueue.poll();
            }

            map[i][y2] = right.pollFirst();
        }

        return list.get(0);
    }
}