import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] check;
    static int tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수빈이 위치
        int K = sc.nextInt(); // 동생 위치
        check = new int[100001]; // 방문 여부 배열

        if (N == K) {
            System.out.println("0");
        }
        else {
            System.out.println(bfs(N, K));
        }
    }

    static int bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();

        check[N] = 1; 
        queue.add(N);

        while (!queue.isEmpty()) {
            tmp = queue.poll();

            if(tmp == K) {
                break;
            }

            if (tmp-1 >= 0 && tmp-1 < 100001 && check[tmp - 1] == 0) {
                check[tmp - 1] = check[tmp] + 1;
                queue.add(tmp-1);
            }
            if (tmp+1 >= 0 && tmp+1 < 100001 && check[tmp + 1] == 0) {
                check[tmp + 1] = check[tmp] + 1;
                queue.add(tmp+1);
            }
            if (tmp*2 >= 0 && tmp*2 < 100001 && check[tmp * 2] == 0) {
                check[tmp * 2] = check[tmp] + 1;
                queue.add(tmp*2);
            }
        }
        return check[tmp]-1;
    }
}