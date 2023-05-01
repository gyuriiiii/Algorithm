import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int F, S, G, U, D;
    static int[] cnt;
    static boolean[] visited;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        cnt = new int[1000001];
        visited = new boolean[1000001];

        if (S > G && D == 0) {
            System.out.println("use the stairs");
            return;
        }
        if (S < G && U == 0) {
            System.out.println("use the stairs");
            return;
        }

        bfs(S);

        if (min == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        }
        else {
            System.out.println(min);
        }
    }

    private static void bfs(int num) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(num);
        visited[num] = true;

        while (!dq.isEmpty()) {
            int now = dq.poll();

            if (now == G) {
                min = cnt[G];
                break;
            }

            for (int i = 0; i < 2; i++) {
                int next = 0;

                if (i == 0) next = now + U; // U 버튼
                if (i == 1) next = now - D; // D 버튼

                if (next < 1 || next > F) {
                    continue;
                }

                if (!visited[next]){
                    visited[next] = true;
                    cnt[next] = cnt[now] + 1;
                    dq.add(next);
                }
            }
        }
    }
}