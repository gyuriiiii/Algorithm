import java.util.ArrayDeque;

public class Solution {
    static public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int sum = 0;

        for (int t : truck_weights) {
            while (true) {
                // 다리 비어있는 경우
                if (queue.isEmpty()) {
                    queue.add(t);
                    sum += t;
                    answer++;
                    break;
                }

                // 다리에 이미 트럭이 있는 경우
                else {
                    // 다리가 트럭으로 꽉 찬 경우
                    if (queue.size() == bridge_length) {
                        sum -= queue.pollFirst();
                    }

                    // 무게 초과하는 경우
                    else if (sum + t > weight) {
                        queue.add(0);
                        answer++;
                    }

                    // 무게 초과하지 않는 경우
                    else {
                        queue.add(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }

        answer += bridge_length;
        return answer;
    }
}