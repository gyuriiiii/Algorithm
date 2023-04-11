import java.util.ArrayDeque;

public class Solution {
    public int solution(int[] priorities, int location) {
        int cnt = 0;

        ArrayDeque<Integer> printer = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            printer.addLast(i); // 각 문서 넣기
        }

        while (!printer.isEmpty()) {
            boolean flag = true;

            int print = printer.pollFirst(); // 가장 앞에 있는 문서
            int priority = priorities[print]; // 가장 앞에 있는 문서의 중요도

            ArrayDeque<Integer> dq = new ArrayDeque<>();

            int size = printer.size();
            for (int i = 0; i < size; i++) {
                int tmp = printer.peekFirst();

                // 중요도 더 높은 문서 발견한 경우
                if (priorities[tmp] > priority) {
                    // 가장 앞에 있던 문서 가장 뒤로 보내기
                    printer.addLast(print);

                    // dq에 있는 문서
                    for (Integer d : dq) {
                        printer.addLast(d);
                    }
                    flag = false;
                    break;
                }
                // 현재 문서가 더 높은 경우
                else {
                    dq.addLast(printer.pollFirst());
                }
            }

            if (flag) {
                // dq에 있는 문서
                for (Integer d : dq) {
                    printer.addLast(d);
                }

                cnt++;
                if (print == location) {
                    break;
                }
            }
        }
        return cnt;
    }
}