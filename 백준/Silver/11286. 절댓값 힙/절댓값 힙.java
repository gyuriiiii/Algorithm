import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // compare 함수 구현시 return 값으로 양수 주면 순서 바꿈
        // 음수이면 안 바꿈
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int A = Math.abs(a);
                int B = Math.abs(b);

                if(A>B) { // 절댓값 더 큰 경우
                    return 1;
                }
                else if(A==B) { // 절댓값 같은 경우
                    if(a>b) return 1; 
                    else return -1; 
                }
                else { // 절댓값 더 작은 경우
                    return -1;
                }
            }
        });

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            if (x == 0) {
                if (queue.size() == 0) {
                    sb.append("0").append("\n");
                } 
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }

            else {
                queue.add(x);
            }
        }
        System.out.println(sb);
    }
}