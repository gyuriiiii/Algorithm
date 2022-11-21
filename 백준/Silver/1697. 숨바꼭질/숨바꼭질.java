import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int K;
    static int[] check;
    static int q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 수빈이 위치
        K = sc.nextInt(); // 동생 위치

        check = new int[100001]; // 방문 여부 배열
        System.out.println(bfs(check, N));
    }
    private static int bfs(int[] check, int N) {
        Queue<Integer> queue = new LinkedList<>(); 

        check[N] = 1; // 방문 여부 표시
        queue.add(N); // 큐에 추가

        while(!queue.isEmpty()) { // 큐 빌 때 까지
            q = queue.poll();

            if(q == K) {
                break;
            }

            if(q-1 >= 0 && q-1 < 100001 && check[q-1] == 0) {
                check[q-1] = check[q] + 1;
                queue.add(q-1);
            }
            if(q+1 >= 0 && q+1 < 100001 && check[q+1] == 0) {
                check[q+1] = check[q] + 1;
                queue.add(q+1);
            }
            if(q*2 >= 0 && q*2 < 100001 && check[q*2] == 0) {
                check[q*2] = check[q] + 1;
                queue.add(q*2);
            }
        }
        return check[q]-1;
    }
}