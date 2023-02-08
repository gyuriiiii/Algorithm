import java.util.Stack;

class Solution {
    private class Num {
        int idx;
        int num;

        public Num(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Num> stack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            int n = prices[i];

            while (!stack.isEmpty()) {
                if (n <= stack.peek().num) {
                    stack.pop();
                }
                else {
                    break;
                }
            }

            if (stack.isEmpty()) {
                answer[i] = len - 1 - i;
            } 
            else {
                answer[i] = stack.peek().idx - i;
            }

            stack.push(new Num(i, n));
        }
        return answer;
    }
}