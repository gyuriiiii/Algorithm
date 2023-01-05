import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수
        for (int i = 0; i < T; i++) {
            Deque<Integer> dq = new ArrayDeque<>();

            String func = sc.next(); // 수행할 함수
            int n = sc.nextInt(); // 배열에 들어있는 수의 개수

            String x = sc.next(); // 배열에 들어있는 정수

            // 분리해 숫자만 deque에 넣기
            StringTokenizer st = new StringTokenizer(x, "[],");
            for (int j = 0; j < n; j++) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }

            AC(dq, func); // 수행할 함수와 덱 넘겨주기
        }
    }

    private static void AC(Deque<Integer> dq, String func) {
        boolean flag = true; // 방향 나타내는 변수

        // 함수 분리
        for (int i = 0; i < func.length(); i++) {
            char p = func.charAt(i);

            int num = 0;

            if (p == 'R') {
                flag = !flag; // 방향 변경

                if (!dq.isEmpty()) {
                    if (flag) { // 정방향
                        num = dq.peekFirst();
                    }

                    else if (!flag) { // 역방향
                        num = dq.peekFirst();
                    }
                }
            }

            else if (p == 'D') {
                // 비어있는 경우 error 출력
                if (dq.isEmpty()) {
                    System.out.println("error");
                    return;
                }

                else {
                    if (flag) { // 정방향
                        dq.removeFirst();
                    }

                    else if (!flag) { // 역방향
                        dq.removeLast();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (dq.isEmpty()) {
            System.out.println("[]");
        } 
        
        else {
            if (flag) {
                int size = dq.size();

                sb.append("[");
                for (int i = 0; i < size - 1; i++) {
                    sb.append(dq.pollFirst() + ",");
                }
                sb.append(dq.pollFirst() + "]");

                System.out.println(sb);
            }

            else if (!flag) {
                int size = dq.size();

                sb.append("[");
                for (int i = 0; i < size - 1; i++) {
                    sb.append(dq.pollLast() + ",");
                }
                sb.append(dq.pollLast() + "]");

                System.out.println(sb);
            }
        }
    }
}