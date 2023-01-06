import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N; // 수빈 위치
    static int K; // 동생 위치

    static int[] arr = new int[100001]; // 위치 배열
    static boolean[] check = new boolean[100001]; // 방문 여부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();

        check[N] = true;
        queue.add(N);

        while (!queue.isEmpty()) {
            int q = queue.poll();

            if (q == K) {
                break;
            }

            if (q * 2 >= 0 && q * 2 < 100001 && !check[q * 2]) { // 순간이동
                queue.add(q * 2);
                check[q * 2] = true;
                arr[q * 2] = arr[q];
            }
            
            if (q - 1 >= 0 && q - 1 < 100001 && !check[q - 1]) { // 걷기 (x-1)
                queue.add(q - 1);
                check[q - 1] = true;
                arr[q - 1] = arr[q] + 1;
            }
            
            if (q + 1 >= 0 && q + 1 < 100001 && !check[q + 1]) { // 걷기 (x+1)
                queue.add(q + 1);
                check[q + 1] = true;
                arr[q + 1] = arr[q] + 1;
            }
        }
        return arr[K];
    }
}