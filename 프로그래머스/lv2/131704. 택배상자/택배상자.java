import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int cnt = 0; // 상자 개수

        Stack<Integer> container = new Stack<>(); // 컨테이너
        for (int i = order.length; i > 0; i--) {
            container.push(i);
        }

        Stack<Integer> tmpContainer = new Stack<>(); // 보조 컨테이너

        int idx = 0; // order 배열 인덱스
        while (!container.isEmpty()) {
            if (container.peek() == order[idx]) { // 해당 택배가 원래 컨테이너 숫자 순서와 같은 경우
                cnt++;
                idx++;
                container.pop(); // 컨테이너에서 해당 숫자 빼기
            } 
            else if(!tmpContainer.isEmpty() && tmpContainer.peek() == order[idx]) { // 원래 컨테이너에 없고 보조 컨테이너에 있는 경우
                cnt++;
                idx++;
                tmpContainer.pop();
            }
            else { // 아예 없는 경우
                tmpContainer.push(container.pop()); // 보조 컨테이너에 넣기
            }
        }

        while(!tmpContainer.isEmpty()) { // 보조 컨테이너 안 비어 있으면
            // 보조 컨테이너에 남은 값도 order과 비교
            if(tmpContainer.peek() == order[idx]) {
                cnt++;
                idx++;
                tmpContainer.pop();
            } 
            else {
                break;
            }
        }
        return cnt;
    }
}