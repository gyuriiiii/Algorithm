import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int cnt = 0;

        HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 각 인형들 map에 넣기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ArrayDeque<Integer> dq = new ArrayDeque<>();

                if (board[i][j] != 0) {
                    if (map.containsKey(j + 1)) {
                        dq = map.get(j + 1);
                        dq.offerLast(board[i][j]);
                        map.put(j + 1, dq);
                    }

                    else {
                        dq.offerLast(board[i][j]);
                        map.put(j + 1, dq);
                    }
                }
            }
        }

        for (int i = 0; i < moves.length; i++) {
            int move = moves[i];

            if (!map.get(move).isEmpty()) {
                int doll = map.get(move).pollFirst();

                if (deque.isEmpty()) { // 바구니 비어있는 경우
                    deque.offerLast(doll);
                } 
                else {
                    if (deque.peekLast() == doll) {
                        deque.pollLast();
                        cnt += 2;
                    } 
                    else {
                        deque.offerLast(doll);
                    }
                }
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}